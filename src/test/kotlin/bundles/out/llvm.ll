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
   %foo = call %Foo* @pipeline$1()
   
   
   %foo2 = call %Foo* @pipeline$2()
   
   
   %v$27 = getelementptr %Foo, ptr %foo, i32 0, i32 0, i32 0, i32 0
   %v$28 = load i32, i32* %v$27
   %v$29 = getelementptr %Foo, ptr %foo2, i32 0, i32 0, i32 0, i32 0
   %v$30 = load i32, i32* %v$29
   %human = call %Human* @pipeline$3(i32 %v$28, i32 %v$30)
   
   
   %v$32 = getelementptr %Human, ptr %human, i32 0, i32 0
   %v$33 = load i32, i32* %v$32
   %v$34 = call i32 @pipeline$4(i32 %v$33)
   
   %v$35 = getelementptr %Human, ptr %human, i32 0, i32 1, i32 0
   %v$36 = load i32, i32* %v$35
   %v$37 = call i32 @pipeline$5(i32 %v$36)
   
   %v$38 = add i32 0, 0
   
   ret i32 %v$38
}
define %Foo* @getFoo(i32 %x) 
{
   %v$39 = call i8* @malloc(i32 4)
   %baz = bitcast i8* %v$39 to %Baz*
   %v$41 = getelementptr %Baz, ptr %baz, i32 0, i32 0
   store i32 %x, ptr %v$41
   
   
   %v$42 = call i8* @malloc(i32 4)
   %bar = bitcast i8* %v$42 to %Bar*
   %v$44 = getelementptr %Bar, ptr %bar, i32 0, i32 0
   %v$45 = bitcast ptr %v$44 to i8*
   %v$46 = bitcast ptr %baz to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$45, ptr %v$46, i32 4, i1 0)
   
   
   
   %v$47 = call i8* @malloc(i32 4)
   %foo = bitcast i8* %v$47 to %Foo*
   %v$49 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$50 = bitcast ptr %v$49 to i8*
   %v$51 = bitcast ptr %bar to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$50, ptr %v$51, i32 4, i1 0)
   
   
   
   
   ret %Foo* %foo
}
define %Human* @getHuman(i32 %hAge, i32 %dAge) 
{
   %v$52 = call i8* @malloc(i32 4)
   %dog = bitcast i8* %v$52 to %Dog*
   %v$54 = getelementptr %Dog, ptr %dog, i32 0, i32 0
   store i32 %dAge, ptr %v$54
   
   
   %v$55 = call i8* @malloc(i32 8)
   %human = bitcast i8* %v$55 to %Human*
   %v$57 = getelementptr %Human, ptr %human, i32 0, i32 0
   store i32 %hAge, ptr %v$57
   %v$58 = getelementptr %Human, ptr %human, i32 0, i32 1
   %v$59 = bitcast ptr %v$58 to i8*
   %v$60 = bitcast ptr %dog to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$59, ptr %v$60, i32 4, i1 0)
   
   
   
   
   ret %Human* %human
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define %Foo* @pipeline$1() 
{
   %pipelineVar$0 = add i32 5, 0
   
   
   %v$62 = call %Foo* @getFoo(i32 %pipelineVar$0)
   
   ret %Foo* %v$62
}
define %Foo* @pipeline$2() 
{
   %pipelineVar$2 = add i32 3, 0
   
   
   %v$64 = call %Foo* @getFoo(i32 %pipelineVar$2)
   
   ret %Foo* %v$64
}
define %Human* @pipeline$3(i32 %foo$bar$baz$qux, i32 %foo2$bar$baz$qux) 
{
   %v$65 = add i32 3, 0
   %v$66 = mul i32 %foo$bar$baz$qux, %v$65
   %v$67 = add i32 %v$66, %foo2$bar$baz$qux
   %v$68 = add i32 1, 0
   %v$69 = add i32 %foo2$bar$baz$qux, %v$68
   %v$70 = call i8* @malloc(i32 8)
   %pipelineVar$4 = bitcast i8* %v$70 to %$$Int$Int$$*
   %v$72 = getelementptr %$$Int$Int$$, ptr %pipelineVar$4, i32 0, i32 0
   store i32 %v$67, ptr %v$72
   %v$73 = getelementptr %$$Int$Int$$, ptr %pipelineVar$4, i32 0, i32 1
   store i32 %v$69, ptr %v$73
   
   
   %v$74 = getelementptr %$$Int$Int$$, ptr %pipelineVar$4, i32 0, i32 0
   %v$75 = load i32, i32* %v$74
   %v$76 = getelementptr %$$Int$Int$$, ptr %pipelineVar$4, i32 0, i32 1
   %v$77 = load i32, i32* %v$76
   %v$78 = call %Human* @getHuman(i32 %v$75, i32 %v$77)
   
   ret %Human* %v$78
}
define i32 @pipeline$4(i32 %human$age) 
{
   
   %v$79 = call i32 @print(i32 %human$age)
   
   ret i32 %v$79
}
define i32 @pipeline$5(i32 %human$dog$age) 
{
   
   %v$80 = call i32 @print(i32 %human$dog$age)
   
   ret i32 %v$80
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
