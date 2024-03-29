import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q43_lv2_괄호회전하기 {
	/* Stack<Character> stack = new Stack<>();
	Queue<Character> queue = new LinkedList<>();
	
    public int solution(String s) {
    	
    	for(char c : s.toCharArray()) {
    		queue.add(c);
    	}
    	
    	int answer = 0;
    	
    	for(int i=0;i<s.length();i++) {
    		if(isCorrect(s))
    			answer++;
    		s = rotateLeft(s);
    	}
    	
        return answer;
    }
    
    private String rotateLeft(String s) {
    	queue.offer(queue.poll());
    	
    	String str = "";
    	Iterator<Character> iterator = queue.iterator();
    	while(iterator.hasNext())
    		str += iterator.next()+"";
    		
    	return str;
    }
    
    private boolean isCorrect(String s) {
    	for(char c : s.toCharArray()) {
    		switch(c) {
    			case '(': 
    				stack.push(')'); break;
				case '[': 
					stack.push(']'); break;
				case '{':
					stack.push('}'); break;
    			case ')': case ']': case '}': 
    				if(stack.isEmpty()) return false;
    				if(stack.pop()!=c) return false;;
    				break;
    		}
    	}
    	return stack.isEmpty();
    } */
	
	public int solution(String s) {
    	char[] str = s.toCharArray();
    	
    	int answer = 0;
    	for(int offset=0;offset<str.length;offset++) {
    		if(isCorrect(str, offset))
    			answer++;
    	}
    	
        return answer;
    }
	
	private boolean isCorrect(char[] str, int offset) {
		Stack<Character> stack = new Stack<>();
		
    	for(int i=0;i<str.length;i++) {
    		char c = str[(offset+i)%str.length]; // 문자열을 회전한 것과 같은 검사 수행 가능
    		
    		switch(c) {
    			case '(': 
    				stack.push(')'); break;
				case '[': 
					stack.push(']'); break;
				case '{':
					stack.push('}'); break;
    			case ')': case ']': case '}': 
    				if(stack.isEmpty()) return false;
    				if(stack.pop()!=c) return false;;
    				break;
    		}
    	}
    	return stack.isEmpty();
    }
}
