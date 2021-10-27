package lin_reg

import breeze.linalg._
import breeze.numerics.{exp, log}
import breeze.stats.mean

import java.io._

object Main {

  def get_df(filename: String): SliceMatrix[Int, Int, Double] = {
    var df = csvread(new File(filename),',', skipLines=1)
    val requiredColumns = List(0, 1, 3, df.cols - 1)
    df(::, requiredColumns)
  }

  def train_split(df: SliceMatrix[Int, Int, Double], train_share: Double = 0.8): (SliceMatrix[Int, Int, Double], SliceMatrix[Int, Int, Double]) = {
    var train_len = (df.rows * train_share).toInt
    (df(0 until train_len, ::), df(train_len until df.rows, ::))
  }

  def get_X(df: SliceMatrix[Int, Int, Double]): DenseMatrix[Double] = {
    var X = df(::, 0 until df.cols-1)
    val extendedX = DenseMatrix.ones[Double](X.rows, X.cols + 1)
    extendedX(::, 1 until extendedX.cols) := X(::, 0 until X.cols)
    extendedX
  }

  def get_y(df: SliceMatrix[Int, Int, Double]): DenseVector[Double] = {
    var y = DenseVector.zeros[Double](df.rows)
    y := df(::, df.cols-1)
    log(y)
  }

  def minMaxScaler(df: SliceMatrix[Int, Int, Double]) : SliceMatrix[Int, Int, Double] = {
    // https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.MinMaxScaler.html
    for (c <- 0 until df.cols-1) {
      var col = df(::, c)
      var min = col.min
      var max = col.max
      var col_std = (col - min) / (max - min)
      var col_scaled = col_std * (max - min) + min
      df(::, c) := col_scaled
    }
    df
  }

  def fit(X: DenseMatrix[Double], y: DenseVector[Double]): DenseVector[Double] = {
    var beta = inv(X.t * X) * X.t * y
    beta
  }

  def predict(X: DenseMatrix[Double], beta: DenseVector[Double]): DenseVector[Double] = {
    var pred_y = X * beta
    exp(pred_y)
  }

  def r2_score(y: DenseVector[Double], pred_y: DenseVector[Double]): Double = {
    var a = y - pred_y
    var b = y - mean(y)
    1.0 - (a.t * a) / (b.t * b)
  }

  def main(args: Array[String]): Unit = {
    val df = get_df(args(0))
    println("Loading dataframe from %s\n".format(args(0)))
    println("Loaded dataframe (rows, cols) = (%d, %d)\n".format(df.rows, df.cols))

    var (df_train, df_test) = train_split(df)
    println("Splitted Train/Val part size = (%d, %d)\n".format(df_train.rows, df_test.rows))

    df_train := minMaxScaler(df_train)
    df_test := minMaxScaler(df_test)
    val X = get_X(df_train)
    val y = get_y(df_train)
    var beta = fit(X, y)
    println("Fitted coefficients:")
    println(beta)
    println()

    var X_test = get_X(df_test)
    var y_test = get_y(df_test)
    var pred_y = predict(X_test, beta)
    var score = r2_score(exp(y_test), pred_y)
    println("R2 score on Val: %f".format(score))
  }
}
