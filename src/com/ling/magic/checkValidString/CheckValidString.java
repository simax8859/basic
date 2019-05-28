package com.ling.magic.checkValidString;


/**
 * @ClassName CheckValidString
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/05/28 9:20
 * @Version 1.0
 **/
public class CheckValidString {
    char r = ')';
    char l = '(';
    char star = '*';
    public Boolean solution(String s){

        byte[] bytes = s.getBytes();
        if (bytes.length == 0){
            return true;
        }
        if (r == bytes[0]){
            return false;
        }
        LinkStack linkStack = new LinkStack();
        //用来倒数据
        LinkStack tempStack = new LinkStack();
        for (int i = 0; i < bytes.length; i++) {
            if (l == bytes[i]) {
                linkStack.push(l);
            } else if (star == bytes[i]) {
                linkStack.push(star);
            } else {
                if(rightIsComing(linkStack, tempStack)){
                    continue;
                }
                return false;
            }
        }
        //如果走到了这一步，证明右括号都被清理干净了，那么只剩下linkStack中的数据还需要进行判断，如果第一次取出的是左括号，凉了
        //如果取出的是星号，往前继续查找抵消左括号，如果碰到抵消不了的，凉凉
        boolean check = checkLinkStack(linkStack);
        return check;
    }


    private boolean rightIsComing(LinkStack linkStack, LinkStack tempStack){
        boolean flag = false;
        //右括号来了！！！
        //优先从栈中取出一个左括号，如果没有，找*替代
        if (linkStack.empty()) {
            return false;
        }
        //遍历寻找左括号
        int length = linkStack.length();
        for (int j = 0; j < length; j++) {
            char peek = (char)linkStack.peek().e;
                //去除一个左括号，再将临时栈中的数据倒回来
                if (peek == l) {
                    linkStack.pop();
                    backStar(linkStack, tempStack);
               //告诉调用方继续吧，该干嘛干嘛，给你处理好了
                    return true;
                } else {
                    //如果是*号就存在临时栈里
                    char e = (char)linkStack.pop().e;
                    tempStack.push(e);
                }
        }
        //一个左括号都没找到吗？那么用*号先顶着吧，要是一个星号都没有，那就凉了
        if (tempStack.empty()) {
            return false;
        }
        tempStack.pop();
        backStar(linkStack, tempStack);
        //用星号搞定了
        return true;
    }

    private boolean checkLinkStack(LinkStack linkStack) {
        int  count = 0;
        while (!linkStack.empty()){
            char e = (char)linkStack.pop().e;
            if (e == l){
                count--;
            }else{
                count++;
            }
            if (count < 0){
                return false;
            }
        }
        return true;
    }

    public void backStar(LinkStack linkStack, LinkStack tempStack){
        while (!tempStack.empty()){
            char e = (char)tempStack.pop().e;
            linkStack.push(e);
        }
    }
}
