class Dna(sequence: String) {
    // Lưu chuỗi DNA và kiểm tra tính hợp lệ ngay trong constructor
    private val sequence: String = sequence.also {
        // Nếu chuỗi chứa ký tự không phải A, C, G, T, ném ngoại lệ
        if (it.any { char -> char !in "ACGT" }) {
            throw IllegalArgumentException("Invalid DNA sequence: contains characters other than A, C, G, T")
        }
    }

    // Getter trả về Map chứa số lần xuất hiện của mỗi nucleotide
    val nucleotideCounts: Map<Char, Int>
        get() {
            // Khởi tạo Map với số lượng mặc định là 0 cho A, C, G, T
            val counts = mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)
            
            // Đếm số lần xuất hiện của mỗi ký tự trong chuỗi
            for (char in sequence) {
                counts[char] = counts[char]!! + 1
            }
            
            // Trả về Map không thay đổi
            return counts
        }
}