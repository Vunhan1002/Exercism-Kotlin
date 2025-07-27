object ETL {
    // Hàm chuyển đổi từ Map điểm số -> tập hợp chữ cái in hoa sang Map chữ cái in thường -> điểm số
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
        // Tạo một Map rỗng để lưu kết quả
        val result = mutableMapOf<Char, Int>()
        
        // Duyệt qua mỗi cặp (điểm số, tập hợp chữ cái) trong source
        for ((score, letters) in source) {
            // Duyệt qua từng chữ cái trong tập hợp
            for (letter in letters) {
                // Chuyển chữ cái in hoa thành in thường và gán điểm số vào result
                result[letter.lowercaseChar()] = score
            }
        }
        
        // Trả về Map kết quả
        return result
    }
}