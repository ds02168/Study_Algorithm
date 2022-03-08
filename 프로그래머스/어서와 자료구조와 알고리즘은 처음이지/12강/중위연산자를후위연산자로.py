class ArrayStack:

    def __init__(self):
        self.data = []

    def size(self):
        return len(self.data)

    def isEmpty(self):
        return self.size() == 0

    def push(self, item):
        self.data.append(item)

    def pop(self):
        return self.data.pop()

    def peek(self):
        return self.data[-1]

prec = {
    '*': 3, '/': 3,
    '+': 2, '-': 2,
    '(': 1
}

def solution(S):
    opStack = ArrayStack()
    answer = ''
    
    for s in S:
        if s.isalpha(): #피연산자
            answer += s
        elif s == '(': #여는 괄호는 무조건 넣기
            opStack.push(s)
        elif s == ')': #닫는 괄호는
            while opStack.peek() != '(': #여는 괄호 나올때까지
                answer += opStack.pop() #pop
            opStack.pop()
        else: #연산자
            if opStack.isEmpty(): #비었으면 그냥 넣기
                opStack.push(s)
            else: #비어있지 않음, 우선순위 비교
                while opStack.isEmpty() == False and prec[opStack.peek()] >= prec[s]:
                    answer += opStack.pop()
                opStack.push(s)
                
        
    while not opStack.isEmpty():
        answer += opStack.pop()
        
    return answer
