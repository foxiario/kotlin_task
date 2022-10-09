fun Int.convert(radix: Int) : Int
{
    val temp = this.toString(radix)
    return temp.toInt()
}
