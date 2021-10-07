// funció principal, de primer nivell.
fun main(args: Array<String>) {
  if (args.isNotEmpty())
    println("Hello ${args[0]}")
  else
    println("Hello World")
}