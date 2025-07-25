import kotlin.math.sqrt

object Darts {

    // Hàm nhận x, y kiểu Any để tương thích với mọi kiểu số (Int, Double)
    fun score(x: Any, y: Any): Int {
        // Ép kiểu x, y về Double (phải đảm bảo x, y là số)
        val xDouble = (x as Number).toDouble()
        val yDouble = (y as Number).toDouble()

        // Tính khoảng cách đến tâm
        val distance = sqrt(xDouble * xDouble + yDouble * yDouble)

        // Trả về điểm tương ứng
        return when {
            distance <= 1.0 -> 10
            distance <= 5.0 -> 5
            distance <= 10.0 -> 1
            else -> 0
        }
    }
}
