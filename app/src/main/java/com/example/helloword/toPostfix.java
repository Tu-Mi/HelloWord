package com.example.helloword;

import java.util.Stack;

public class toPostfix {
    public static StringBuffer toPostfix(String infix){
        Stack<String> stack = new Stack<String>();
        StringBuffer postfix = new StringBuffer(infix.length()*2);
        int i=0;
        while (i<infix.length())
        {
            char ch=infix.charAt(i);
            switch (ch)
            {
                case '+': case '-':
                while (!stack.isEmpty() && !stack.peek().equals("("))
                    postfix.append(stack.pop());
                stack.push(ch+"");
                i++;  break;

                case '*': case '/':
                while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/")))
                    postfix.append(stack.pop());
                stack.push(ch+"");
                i++;  break;

                case '(':
                    stack.push(ch+"");
                    i++;  break;

                case ')':
                    String out = stack.pop();
                    while (out!=null && !out.equals("("))
                    {   postfix.append(out);
                        out = stack.pop();
                    }
                    i++;  break;

                default:
                    while (i<infix.length() && ch>='0' && ch<='9'||ch=='.')
                    {   postfix.append(ch);
                        i++;
                        if (i<infix.length())
                            ch=infix.charAt(i);
                    }
                    postfix.append(" ");
            }
        }
        while (!stack.isEmpty())
            postfix.append(stack.pop());
        return postfix;
    }
}
