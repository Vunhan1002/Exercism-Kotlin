fun transcribeToRna(dna: String): String {
    return dna.map { nucleotide -> // Duyệt từng ký tự (nucleotide) trong chuỗi DNA
        when (nucleotide) {
            'G' -> 'C'  // G -> C
            'C' -> 'G'  // C -> G
            'T' -> 'A'  // T -> A
            'A' -> 'U'  // A -> U
            else -> throw IllegalArgumentException("Invalid DNA nucleotide: $nucleotide")
            // Nếu gặp ký tự không hợp lệ thì báo lỗi
        }
    }.joinToString("") // Nối các ký tự RNA lại thành chuỗi hoàn chỉnh
}