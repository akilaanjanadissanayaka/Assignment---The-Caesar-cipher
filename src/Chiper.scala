import scala.io.StdIn._
import scala.io.Source._

object Chiper extends App{
  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ."
  val Encryption = (c:Char,key:Int,s:String) => (s((s.indexOf(c) + key)%s.size))
  val Decryption = (c:Char,key:Int,s:String) => (if((s.indexOf(c) - key) <0) s(s.size - math.abs((s.indexOf(c) - key))) else s((s.indexOf(c) - key))) 
  val Cipher = (f:(Char, Int, String) => Char,c:Char,key:Int,s:String) => f(c:Char,key:Int,s:String)
  
  val key = 3
  print("Enter Text :");
  val source = scala.io.StdIn.readLine().toUpperCase();
  
  val encryptedString = source.map(x => Cipher(Encryption,x,key,alphabet))
  println("Encrypted string	: " + encryptedString)

  val decryptLetter = encryptedString.map(y => Cipher(Decryption,y,key,alphabet))
  println("Decrypted string 	: " + decryptLetter)
  
}



