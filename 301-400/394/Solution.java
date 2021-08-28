/**
 * 已知表达式k[str] = str + str + ... + str，累加k次
 * 先给出一个字符串表达式，求最终生成的字符串
 * 
 * 栈运算
 * 
 * 1ms, 37.3 MB
 */
class Solution {
    static class Element {
        public int time;
        public StringBuilder str;

        public Element(int time, String str) {
            this.time = time;
            this.str = new StringBuilder(str);
        }

    }

    List<Element> list;

    public String decodeString(String s) {
        list = new ArrayList<>();
        int len = s.length();
        int top = 0;
        Element element = new Element(1, "");
        list.add(element);
        int idx = 0;
        while (idx < len) {
            char c = s.charAt(idx);
            if (c >= 'a' && c <= 'z') {
                list.get(top).str.append(c);
            } else if (c >= '0' && c <= '9') {
                StringBuilder number = new StringBuilder(String.valueOf(c));
                for (++idx; idx < len && s.charAt(idx) != '['; idx++) {
                    number.append(s.charAt(idx));
                }
                element = new Element(Integer.parseInt(number.toString()), "");
                list.add(element);
                top++;
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder("");
                for (int i = 0; i < list.get(top).time; i++) {
                    temp.append(list.get(top).str);
                }
                list.remove(top--);
                list.get(top).str.append(temp);
            }
            idx++;
        }
        while (top > 0) {
            StringBuilder temp = new StringBuilder("");
            for (int i = 0; i < list.get(top).time; i++) {
                temp.append(list.get(top).str);
            }
            list.remove(top--);
            list.get(top).str.append(temp);
        }
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < list.get(top).time; i++) {
            result.append(list.get(top).str);
        }
        return result.toString();
    }
}
