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
   %foo = call %Foo* @pipeline$2()
   
   
   %foo2 = call %Foo* @pipeline$3()
   
   
   %v$53 = getelementptr %Foo, ptr %foo, i32 0, i32 0, i32 0, i32 0
   %v$54 = load i32, i32* %v$53
   %v$55 = getelementptr %Foo, ptr %foo2, i32 0, i32 0, i32 0, i32 0
   %v$56 = load i32, i32* %v$55
   %human = call %Human* @pipeline$4(i32 %v$54, i32 %v$56)
   
   
   %v$58 = getelementptr %Human, ptr %human, i32 0, i32 0
   %v$59 = load i32, i32* %v$58
   %v$60 = call i32 @pipeline$5(i32 %v$59)
   
   %v$61 = getelementptr %Human, ptr %human, i32 0, i32 1, i32 0
   %v$62 = load i32, i32* %v$61
   %v$63 = call i32 @pipeline$6(i32 %v$62)
   
   %v$64 = add i32 0, 0
   
   ret i32 %v$64
}
define %Foo* @getFoo(i32 %x) 
{
   %v$65 = call i8* @malloc(i32 4)
   %baz = bitcast i8* %v$65 to %Baz*
   %v$67 = getelementptr %Baz, ptr %baz, i32 0, i32 0
   store i32 %x, ptr %v$67
   
   
   %v$68 = call i8* @malloc(i32 4)
   %bar = bitcast i8* %v$68 to %Bar*
   %v$70 = getelementptr %Bar, ptr %bar, i32 0, i32 0
   %v$71 = bitcast ptr %v$70 to i8*
   %v$72 = bitcast ptr %baz to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$71, ptr %v$72, i32 4, i1 0)
   
   
   
   %v$73 = call i8* @malloc(i32 4)
   %foo = bitcast i8* %v$73 to %Foo*
   %v$75 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$76 = bitcast ptr %v$75 to i8*
   %v$77 = bitcast ptr %bar to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$76, ptr %v$77, i32 4, i1 0)
   
   
   
   
   ret %Foo* %foo
}
define %Human* @getHuman(i32 %hAge, i32 %dAge) 
{
   %v$78 = call i8* @malloc(i32 4)
   %dog = bitcast i8* %v$78 to %Dog*
   %v$80 = getelementptr %Dog, ptr %dog, i32 0, i32 0
   store i32 %dAge, ptr %v$80
   
   
   %v$81 = call i8* @malloc(i32 8)
   %human = bitcast i8* %v$81 to %Human*
   %v$83 = getelementptr %Human, ptr %human, i32 0, i32 0
   store i32 %hAge, ptr %v$83
   %v$84 = getelementptr %Human, ptr %human, i32 0, i32 1
   %v$85 = bitcast ptr %v$84 to i8*
   %v$86 = bitcast ptr %dog to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$85, ptr %v$86, i32 4, i1 0)
   
   
   
   
   ret %Human* %human
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define %Foo* @pipeline$2() 
{
   %pipelineVar$0 = add i32 5, 0
   
   
   %v$88 = call %Foo* @getFoo(i32 h)
   
   ret %Foo* %v$88
}
define %Foo* @pipeline$3() 
{
   %pipelineVar$2 = add i32 3, 0
   
   
   %v$90 = call %Foo* @getFoo(i32 %pipelineVar$2)
   
   ret %Foo* %v$90
}
define %Human* @pipeline$4(i32 %foo$bar$baz$qux, i32 %foo2$bar$baz$qux) 
{
   %v$91 = add i32 3, 0
   %v$92 = mul i32 %foo$bar$baz$qux, %v$91
   %v$93 = add i32 %v$92, %foo2$bar$baz$qux
   %v$94 = add i32 1, 0
   %v$95 = add i32 %foo2$bar$baz$qux, %v$94
   %v$96 = call i8* @malloc(i32 8)
   %pipelineVar$4 = bitcast i8* %v$96 to %$$Int$Int$$*
   %v$98 = getelementptr %$$Int$Int$$, ptr %pipelineVar$4, i32 0, i32 0
   store i32 %v$93, ptr %v$98
   %v$99 = getelementptr %$$Int$Int$$, ptr %pipelineVar$4, i32 0, i32 1
   store i32 %v$95, ptr %v$99
   
   
   %v$100 = getelementptr %$$Int$Int$$, ptr %pipelineVar$4, i32 0, i32 0
   %v$101 = load i32, i32* %v$100
   %v$102 = getelementptr %$$Int$Int$$, ptr %pipelineVar$4, i32 0, i32 1
   %v$103 = load i32, i32* %v$102
   %v$104 = call %Human* @getHuman(i32 %v$101, i32 %v$103)
   
   ret %Human* %v$104
}
define i32 @pipeline$5(i32 %human$age) 
{
   
   %v$105 = call i32 @print(i32 %human$age)
   
   ret i32 %v$105
}
define i32 @pipeline$6(i32 %human$dog$age) 
{
   
   %v$106 = call i32 @print(i32 %human$dog$age)
   
   ret i32 %v$106
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
