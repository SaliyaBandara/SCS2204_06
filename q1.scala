@main def init() ={
    def caesarEncrypt(text: String, shift: Int): String = {
    val alphabetSize = 26
        text.map { c =>
            if (c.isLetter) {
                val base = if (c.isUpper) 'A' else 'a'
                val shiftedChar = (base + (c - base + shift + alphabetSize) % alphabetSize).toChar
                shiftedChar
            } else {
                c
            }
        }
    }

    def caesarDecrypt(encryptedText: String, shift: Int): String = {
        caesarEncrypt(encryptedText, -shift)
    }

    def cipher(process: (String, Int) => String, text: String, shift: Int): String = {
        process(text, shift)
    }

    val plaintext = "Hello, World!"
    val shiftValue = 3  
    
    val encryptedText = cipher(caesarEncrypt, plaintext, shiftValue)
    println("Encrypted Text: " + encryptedText) 
    
    val decryptedText = cipher(caesarDecrypt, encryptedText, shiftValue)
    println("Decrypted Text: " + decryptedText)
}