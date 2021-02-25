import Complex
import Matrix

fun main(args: Array<String>) {
    val data = arrayOf (
        arrayOf(Complex(1.0, 0.0), Complex(3.0, 0.0), Complex(1.0, 0.0)),
        arrayOf(Complex(2.0, 0.0), Complex(1.0, 0.0), Complex(2.0, 0.0))
        )

    val matrix = Matrix(2, 3, data)
    val matrix1 = Matrix(2,3, data)
    val matrix_t = matrix.transpose()
    val matrix_plus = matrix + matrix1;
    val matrix_times = matrix * matrix_t;
    println("Original matrix: ")
    println(matrix)
    println("Transposed matrix: ")
    println(matrix_t)
    println("Original matrix + Original matrix: ")
    println(matrix_plus)
    println("Original matrix * Transposed matrix: ")
    println(matrix_times)
}