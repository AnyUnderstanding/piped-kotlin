%$$Int$Int$$ = type {
   i32,
   i32
}

define i32 @main() 
{
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   
   ret i32 %v$99
}
define i32 @add(i32 %a, i32 %b) 
{
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   
   ret i32 %v$100
}
define i32 @printTuple(i32 %a, i32 %b) 
{
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   
   ret i32 %v$103
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   
   ret i32 %value
}
define i32 @pipeLine0(i32 %field0, i32 %field1) 
{
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %pipeLineVar0 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %pipeLineVar0 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %v$107 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$111 = load i32, i32* %v$110
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$113 = load i32, i32* %v$112
   %pipeLineVar1 = call i32 @add(i32 %v$111, i32 %v$113)
   
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %pipeLineVar0 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %v$107 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$111 = load i32, i32* %v$110
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$113 = load i32, i32* %v$112
   %pipeLineVar1 = call i32 @add(i32 %v$111, i32 %v$113)
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %v$107 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$111 = load i32, i32* %v$110
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$113 = load i32, i32* %v$112
   %pipeLineVar2 = call i32 @add(i32 %v$111, i32 %v$113)
   
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %v$107 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$111 = load i32, i32* %v$110
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$113 = load i32, i32* %v$112
   %v$114 = call i32 @add(i32 %v$111, i32 %v$113)
   %v$115 = getelementptr %$$Int$Int$$, ptr %pipeLineVar2, i32 0, i32 0
   %v$116 = load i32, i32* %v$115
   %v$117 = getelementptr %$$Int$Int$$, ptr %pipeLineVar2, i32 0, i32 1
   %v$118 = load i32, i32* %v$117
   %v$119 = call i32 @printTuple(i32 %v$116, i32 %v$118)
   
   ret i32 %v$119
}
define i32 @pipeLine1(i32 %field0) 
{
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %pipeLineVar0 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %v$107 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$111 = load i32, i32* %v$110
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$113 = load i32, i32* %v$112
   %pipeLineVar1 = call i32 @add(i32 %v$111, i32 %v$113)
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %v$107 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$111 = load i32, i32* %v$110
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$113 = load i32, i32* %v$112
   %pipeLineVar2 = call i32 @add(i32 %v$111, i32 %v$113)
   
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %v$107 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$111 = load i32, i32* %v$110
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$113 = load i32, i32* %v$112
   %v$114 = call i32 @add(i32 %v$111, i32 %v$113)
   %v$115 = getelementptr %$$Int$Int$$, ptr %pipeLineVar2, i32 0, i32 0
   %v$116 = load i32, i32* %v$115
   %v$117 = getelementptr %$$Int$Int$$, ptr %pipeLineVar2, i32 0, i32 1
   %v$118 = load i32, i32* %v$117
   %v$119 = call i32 @printTuple(i32 %v$116, i32 %v$118)
   %v$120 = call i32 @print(i32 %a)
   
   ret i32 %v$120
}
define i32 @pipeLine2(i32 %field0) 
{
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %pipeLineVar0 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %v$107 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$111 = load i32, i32* %v$110
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$113 = load i32, i32* %v$112
   %pipeLineVar1 = call i32 @add(i32 %v$111, i32 %v$113)
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %v$107 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$111 = load i32, i32* %v$110
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$113 = load i32, i32* %v$112
   %pipeLineVar2 = call i32 @add(i32 %v$111, i32 %v$113)
   
   
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i32 @pipeLine0(i32 %v$96, i32 %v$97)
   %v$99 = add i32 0, 0
   %v$100 = add i32 %a, %b
   %v$101 = call i32 @pipeLine1(i32 %a)
   %v$102 = call i32 @pipeLine2(i32 %b)
   %v$103 = add i32 0, 0
   %v$104 = add i32 1, 0
   %v$105 = add i32 4, 0
   %v$106 = call i8* @malloc(i32 8)
   %v$107 = bitcast i8* %v$106 to %$$Int$Int$$*
   %v$108 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 0
   store i32 %v$104, ptr %v$108
   %v$109 = getelementptr %$$Int$Int$$, ptr %v$107, i32 0, i32 1
   store i32 %v$105, ptr %v$109
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$111 = load i32, i32* %v$110
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$113 = load i32, i32* %v$112
   %v$114 = call i32 @add(i32 %v$111, i32 %v$113)
   %v$115 = getelementptr %$$Int$Int$$, ptr %pipeLineVar2, i32 0, i32 0
   %v$116 = load i32, i32* %v$115
   %v$117 = getelementptr %$$Int$Int$$, ptr %pipeLineVar2, i32 0, i32 1
   %v$118 = load i32, i32* %v$117
   %v$119 = call i32 @printTuple(i32 %v$116, i32 %v$118)
   %v$120 = call i32 @print(i32 %a)
   %v$121 = call i32 @print(i32 %b)
   
   ret i32 %v$121
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
