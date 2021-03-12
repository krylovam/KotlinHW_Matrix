class Matrix constructor(height : Int, width : Int)
{
    var height : Int
    var width : Int
    var data : Array < Array < Complex > >
    init
    {
        this.height = height
        this.width = width
        this.data = Array(height) { Array(width) { i -> Complex(0.0, 0.0) } }
    }
    constructor(height: Int, width: Int, data : Array < Array < Complex > >) : this (height, width)
    {
        this.data = data
    }
    operator fun get(row : Int, col : Int): Complex
    {
        return data[row][col]
    }

    operator fun set(row : Int, col : Int, value: Complex)
    {
        data[row][col] = value
    }

    fun transpose(): Matrix
    {
        val resultMatrix = Matrix(width, height)
        for (i in 0 until height) {
            for (j in 0 until width) {
                resultMatrix[j, i] = this[i, j]
            }
        }
        return resultMatrix
    }

    operator fun plus( otherMatrix: Matrix): Matrix
    {
        if (width != otherMatrix.width || height != otherMatrix.height) {
            throw IncompatibleMatricesException("Matrices have different number of rows or columns")
        }
        val resultMatrix = Matrix(height, width)
        for (i in 0 until height) {
            for (j in 0 until width) {
                resultMatrix[i, j] = this[i, j] + otherMatrix[i, j]
            }
        }
        return resultMatrix
    }

    operator fun times( otherMatrix : Matrix): Matrix
    {
        if (height != otherMatrix.width || width != otherMatrix.height) {
            throw IncompatibleMatricesException("Matrices have incompatible number of rows or columns")
        }
        val resultMatrix = Matrix(height, otherMatrix.width)
        for (i in 0 until height) {
            for (j in 0 until otherMatrix.width) {
                for (k in 0 until width) {
                    resultMatrix[i, j] += this[i, k] * otherMatrix[k, j]
                }
            }
        }
        return resultMatrix
    }

    override fun toString(): String
    {
        val result = StringBuilder()
        for (i in 0 until height) {
            for (j in 0 until width) {
                result.append(data[i][j].toString() + " ")
            }
            result.append("\n")
        }
        return result.toString()
    }
}

class IncompatibleMatricesException(message:String): Exception(message)