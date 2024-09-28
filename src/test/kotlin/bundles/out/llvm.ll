%Foo = type {
   %Bar
}

%Bar = type {
   %Baz
}

%Baz = type {
   i32
}

%Human = type {
   i32,
   %Dog
}

%Dog = type {
   i32
}

%$$Int$Int$$ = type {
   i32,
   i32
}

define i32 @main() 
{
   %v$56 = add i32 5, 0
   %foo = call %Foo* @pipeLine0(i32 %v$56)
   
   
   %v$58 = add i32 3, 0
   %foo2 = call %Foo* @pipeLine1(i32 %v$58)
   
   
   %v$60 = getelementptr %Foo, ptr %foo, i32 0, i32 0, i32 0, i32 0
   %v$61 = load i32, i32* %v$60
   %v$62 = add i32 3, 0
   %v$63 = mul i32 %v$61, %v$62
   %v$64 = getelementptr %Foo, ptr %foo2, i32 0, i32 0, i32 0, i32 0
   %v$65 = load i32, i32* %v$64
   %v$66 = add i32 %v$63, %v$65
   %v$67 = getelementptr %Foo, ptr %foo2, i32 0, i32 0, i32 0, i32 0
   %v$68 = load i32, i32* %v$67
   %v$69 = add i32 1, 0
   %v$70 = add i32 %v$68, %v$69
   %human = call %Human* @pipeLine2(i32 %v$66, i32 %v$70)
   
   
   %v$72 = getelementptr %Human, ptr %human, i32 0, i32 0
   %v$73 = load i32, i32* %v$72
   %v$74 = call i32 @pipeLine3(i32 %v$73)
   
   %v$75 = getelementptr %Human, ptr %human, i32 0, i32 1, i32 0
   %v$76 = load i32, i32* %v$75
   %v$77 = call i32 @pipeLine4(i32 %v$76)
   
   %v$78 = add i32 0, 0
   
   ret i32 %v$78
}
define %Foo* @getFoo(i32 %x) 
{
   %v$79 = call i8* @malloc(i32 4)
   %baz = bitcast i8* %v$79 to %Baz*
   %v$81 = getelementptr %Baz, ptr %baz, i32 0, i32 0
   store i32 %x, ptr %v$81
   
   
   %v$82 = call i8* @malloc(i32 4)
   %bar = bitcast i8* %v$82 to %Bar*
   %v$84 = getelementptr %Bar, ptr %bar, i32 0, i32 0
   %v$85 = bitcast ptr %v$84 to i8*
   %v$86 = bitcast ptr %baz to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$85, ptr %v$86, i32 4, i1 0)
   
   
   
   %v$87 = call i8* @malloc(i32 4)
   %foo = bitcast i8* %v$87 to %Foo*
   %v$89 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$90 = bitcast ptr %v$89 to i8*
   %v$91 = bitcast ptr %bar to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$90, ptr %v$91, i32 4, i1 0)
   
   
   
   
   ret %Foo* %foo
}
define %Human* @getHuman(i32 %hAge, i32 %dAge) 
{
   %v$92 = call i8* @malloc(i32 4)
   %dog = bitcast i8* %v$92 to %Dog*
   %v$94 = getelementptr %Dog, ptr %dog, i32 0, i32 0
   store i32 %dAge, ptr %v$94
   
   
   %v$95 = call i8* @malloc(i32 8)
   %human = bitcast i8* %v$95 to %Human*
   %v$97 = getelementptr %Human, ptr %human, i32 0, i32 0
   store i32 %hAge, ptr %v$97
   %v$98 = getelementptr %Human, ptr %human, i32 0, i32 1
   %v$99 = bitcast ptr %v$98 to i8*
   %v$100 = bitcast ptr %dog to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$99, ptr %v$100, i32 4, i1 0)
   
   
   
   
   ret %Human* %human
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define %Foo* @pipeLine0(i32 %field0) 
{
   %pipeLineVar0 = add i32 5, 0
   
   
   %v$102 = call %Foo* @getFoo(i32 %pipeLineVar0)
   
   ret %Foo* %v$102
}
define %Foo* @pipeLine1(i32 %field0) 
{
   %pipeLineVar2 = add i32 3, 0
   
   
   %v$104 = call %Foo* @getFoo(i32 %pipeLineVar2)
   
   ret %Foo* %v$104
}
define %Human* @pipeLine2(i32 %field0, i32 %field1) 
{
   %v$105 = getelementptr %Foo, ptr %foo, i32 0, i32 0, i32 0, i32 0
   %v$106 = load i32, i32* %v$105
   %v$107 = add i32 3, 0
   %v$108 = mul i32 %v$106, %v$107
   %v$109 = getelementptr %Foo, ptr %foo2, i32 0, i32 0, i32 0, i32 0
   %v$110 = load i32, i32* %v$109
   %v$111 = add i32 %v$108, %v$110
   %v$112 = getelementptr %Foo, ptr %foo2, i32 0, i32 0, i32 0, i32 0
   %v$113 = load i32, i32* %v$112
   %v$114 = add i32 1, 0
   %v$115 = add i32 %v$113, %v$114
   %v$116 = call i8* @malloc(i32 8)
   %pipeLineVar4 = bitcast i8* %v$116 to %$$Int$Int$$*
   %v$118 = getelementptr %$$Int$Int$$, ptr %pipeLineVar4, i32 0, i32 0
   store i32 %v$111, ptr %v$118
   %v$119 = getelementptr %$$Int$Int$$, ptr %pipeLineVar4, i32 0, i32 1
   store i32 %v$115, ptr %v$119
   
   
   %v$120 = getelementptr %$$Int$Int$$, ptr %pipeLineVar4, i32 0, i32 0
   %v$121 = load i32, i32* %v$120
   %v$122 = getelementptr %$$Int$Int$$, ptr %pipeLineVar4, i32 0, i32 1
   %v$123 = load i32, i32* %v$122
   %v$124 = call %Human* @getHuman(i32 %v$121, i32 %v$123)
   
   ret %Human* %v$124
}
define i32 @pipeLine3(i32 %field0) 
{
   
   %v$125 = call i32 @print(i32 %human)
   
   ret i32 %v$125
}
define i32 @pipeLine4(i32 %field0) 
{
   
   %v$126 = call i32 @print(i32 %human)
   
   ret i32 %v$126
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
