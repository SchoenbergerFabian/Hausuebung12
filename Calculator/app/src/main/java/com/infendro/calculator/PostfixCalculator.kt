package com.infendro.calculator

import java.math.BigDecimal

class PostfixCalculator(val postfix: List<String>) {
    private val stack = ArrayDeque<Double>()

    fun getResult() : BigDecimal {
        var operand1: BigDecimal
        var operand2: BigDecimal

        for (i in 0 until postfix.size) {
            if (postfix[i].equals("+") || postfix[i].equals("-") || postfix[i].equals("*") || postfix[i].equals("/")) {
                operand2 = BigDecimal.valueOf(stack.removeLast())
                operand1 = BigDecimal.valueOf(stack.removeLast())

                when (postfix[i]) {
                    "+" -> {
                        val local = operand1.add(operand2)
                        stack.addLast(local.toDouble())
                    }
                    "-" -> {
                        val local = operand1.subtract(operand2)
                        stack.addLast(local.toDouble())
                    }
                    "*" -> {
                        val local = operand1.multiply(operand2)
                        stack.addLast(local.toDouble())
                    }
                    "/" -> {
                        val local = operand1.divide(operand2)
                        stack.addLast(local.toDouble())
                    }
                }
            } else {
                stack.addLast(postfix[i].toDouble())
            }
        }

        return BigDecimal.valueOf(stack.removeLast())
    }

}