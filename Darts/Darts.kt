object Darts {
    // Hàm tính điểm dựa trên tọa độ x, y của phi tiêu
    fun score(x: Double, y: Double): Int {
        // Tính khoảng cách từ điểm (x, y) đến tâm (0, 0) bằng công thức Euclidean
        val distance = Math.sqrt(x * x + y * y)
        
        // Kiểm tra vị trí của phi tiêu và trả về số điểm tương ứng
        return when {
            // Nếu khoảng cách > 10, phi tiêu ở ngoài mục tiêu: 0 điểm
            distance > 10 -> 0
            // Nếu khoảng cách <= 10 và > 5, phi tiêu ở vòng ngoài: 1 điểm
            distance > 5 -> 1
            // Nếu khoảng cách <= 5 và > 1, phi tiêu ở vòng giữa: 5 điểm
            distance > 1 -> 5
            // Nếu khoảng cách <= 1, phi tiêu ở vòng trong (bullseye): 10 điểm
            else -> 10
        }
    }
}