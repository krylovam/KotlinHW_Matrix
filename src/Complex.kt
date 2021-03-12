class Complex constructor(re : Double, im : Double)
{
    var re : Double
    var im : Double
    init
    {
        this.re = re
        this.im = im
    }

    operator fun plus(otherValue: Complex): Complex
    {
        return Complex(re + otherValue.re, im + otherValue.im)
    }

    operator fun plus(otherValue: Double): Complex
    {
        return Complex(re + otherValue, im)
    }

    operator fun minus(otherValue: Complex): Complex
    {
        return Complex(re - otherValue.re, im - otherValue.im)
    }

    operator fun minus(otherValue: Double): Complex
    {
        return Complex(re - otherValue, im)
    }

    operator fun times(otherValue: Complex): Complex
    {
        return Complex(re * otherValue.re - im * otherValue.im,
                       re * otherValue.im + im * otherValue.re)
    }

    operator fun times(otherValue: Double): Complex
    {
        return Complex(re * otherValue,  im * otherValue)
    }

    override fun toString() : String
    {
        var result = "$re"
        if (im == 0.0) {
            return result
        }
        if (im > 0){
            result += "+$im"
        }
        else {
            result += "-" + (-im).toString()
        }
        result += "*i"
        return result
    }
}