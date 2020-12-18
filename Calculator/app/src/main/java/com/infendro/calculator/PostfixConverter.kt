package com.infendro.calculator

class PostFixConverter(val infix: String) {

    private fun getPrecedence(op: Char): Int {
        return if (op == '*' || op == '/') 2 else if (op == '+' || op == '-') 1 else -1
    }

    /*private*/ fun getPostfixExpression() : String{
        var output = ""
        var append : Char

        val stack = ArrayDeque<Char>()

        infix.forEach { ch ->
            run {
                when (ch) {
                    '+', '-', '*', '/' -> {
                        while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.last())) {
                            append = stack.removeLast()
                            output += " " + append
                        }
                        stack.addLast(ch)
                        output += " "
                    }
                    '(' -> {
                        stack.addLast(ch)
                    }
                    ')' -> {
                        while (!stack.isEmpty() && stack.last() != '(') {
                            append = stack.removeLast()
                            output += " " + append
                        }
                        if (!stack.isEmpty() && stack.last() == '(')
                            append = stack.removeLast()
                    }
                    else -> {
                        output += ch
                    }

                }
            }
        }
        while (!stack.isEmpty())
        {
            append = stack.removeLast()
            output += " "+append
        }
        return output
    }

    fun getPostfixAsList() : List<String>{
        return getPostfixExpression().split(" ")
    }
}