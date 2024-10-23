%Foo = type {
   i32,
   i32
}

%$$Int$Int$$ = type {
   i32,
   i32
}

%$$Foo$Int$$ = type {
   %Foo,
   i32
}

define i32 @main() 
{
   %v$0 = call i32 @pipeline$1()
   
   %x = add i32 1, 0
   
   
   %v$2 = call i32 @pipeline$3(i32 %x)
   
   %v$3 = add i32 5, 0
   %v$4 = add i32 10, 0
   %v$5 = call i8* @malloc(i32 8)
   %foo = bitcast i8* %v$5 to %Foo*
   %v$7 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   store i32 %v$3, ptr %v$7
   %v$8 = getelementptr %Foo, ptr %foo, i32 0, i32 1
   store i32 %v$4, ptr %v$8
   
   
   %v$9 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$10 = load i32, i32* %v$9
   %v$11 = getelementptr %Foo, ptr %foo, i32 0, i32 1
   %v$12 = load i32, i32* %v$11
   %v$13 = call i32 @pipeline$5(%Foo* %foo, i32 %v$10, i32 %v$12)
   
   %v$14 = call i32 @pipeline$7(%Foo* %foo)
   
   %v$15 = add i32 0, 0
   
   ret i32 %v$15
}
define i32 @add(i32 %a, i32 %b) 
{
   %v$16 = add i32 %a, %b
   
   ret i32 %v$16
}
define i32 @combine(%Foo* %foo, i32 %value) 
{
   %v$17 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$18 = load i32, i32* %v$17
   %v$19 = mul i32 %v$18, %value
   %v$20 = getelementptr %Foo, ptr %foo, i32 0, i32 1
   %v$21 = load i32, i32* %v$20
   %v$22 = add i32 %v$19, %v$21
   
   ret i32 %v$22
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeline$0() 
{
   %v$23 = add i32 1, 0
   %v$24 = add i32 2, 0
   %v$25 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$25 to %$$Int$Int$$*
   %v$27 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %v$23, ptr %v$27
   %v$28 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %v$24, ptr %v$28
   
   
   %v$29 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$30 = load i32, i32* %v$29
   %v$31 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$32 = load i32, i32* %v$31
   %v$33 = call i32 @add(i32 %v$30, i32 %v$32)
   
   ret i32 %v$33
}
define i32 @pipeline$1() 
{
   %v$34 = add i32 1, 0
   %v$35 = call i32 @pipeline$0()
   %v$36 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$36 to %$$Int$Int$$*
   %v$38 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %v$34, ptr %v$38
   %v$39 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %v$35, ptr %v$39
   
   
   %v$40 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$41 = load i32, i32* %v$40
   %v$42 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$43 = load i32, i32* %v$42
   %pipelineVar$1 = call i32 @add(i32 %v$41, i32 %v$43)
   
   
   %v$45 = call i32 @print(i32 %pipelineVar$1)
   
   ret i32 %v$45
}
define i32 @pipeline$2(i32 %x) 
{
   %v$46 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$46 to %$$Int$Int$$*
   %v$48 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %x, ptr %v$48
   %v$49 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %x, ptr %v$49
   
   
   %v$50 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$51 = load i32, i32* %v$50
   %v$52 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$53 = load i32, i32* %v$52
   %v$54 = call i32 @add(i32 %v$51, i32 %v$53)
   
   ret i32 %v$54
}
define i32 @pipeline$3(i32 %x) 
{
   %v$55 = call i32 @pipeline$2(i32 %x)
   %v$56 = call i8* @malloc(i32 8)
   %pipelineVar$3 = bitcast i8* %v$56 to %$$Int$Int$$*
   %v$58 = getelementptr %$$Int$Int$$, ptr %pipelineVar$3, i32 0, i32 0
   store i32 %x, ptr %v$58
   %v$59 = getelementptr %$$Int$Int$$, ptr %pipelineVar$3, i32 0, i32 1
   store i32 %v$55, ptr %v$59
   
   
   %v$60 = getelementptr %$$Int$Int$$, ptr %pipelineVar$3, i32 0, i32 0
   %v$61 = load i32, i32* %v$60
   %v$62 = getelementptr %$$Int$Int$$, ptr %pipelineVar$3, i32 0, i32 1
   %v$63 = load i32, i32* %v$62
   %pipelineVar$4 = call i32 @add(i32 %v$61, i32 %v$63)
   
   
   %v$65 = call i32 @print(i32 %pipelineVar$4)
   
   ret i32 %v$65
}
define i32 @pipeline$4(i32 %foo$bar, i32 %foo$baz) 
{
   %v$66 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$66 to %$$Int$Int$$*
   %v$68 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %foo$bar, ptr %v$68
   %v$69 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %foo$baz, ptr %v$69
   
   
   %v$70 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$71 = load i32, i32* %v$70
   %v$72 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$73 = load i32, i32* %v$72
   %v$74 = call i32 @add(i32 %v$71, i32 %v$73)
   
   ret i32 %v$74
}
define i32 @pipeline$5(%Foo* %foo, i32 %foo$bar, i32 %foo$baz) 
{
   %v$75 = call i32 @pipeline$4(i32 %foo$bar, i32 %foo$baz)
   %v$76 = call i8* @malloc(i32 12)
   %pipelineVar$6 = bitcast i8* %v$76 to %$$Foo$Int$$*
   %v$78 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$6, i32 0, i32 0
   %v$79 = bitcast ptr %v$78 to i8*
   %v$80 = bitcast ptr %foo to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$79, ptr %v$80, i32 8, i1 0)
   
   %v$81 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$6, i32 0, i32 1
   store i32 %v$75, ptr %v$81
   
   
   %v$82 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$6, i32 0, i32 0
   %v$83 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$6, i32 0, i32 1
   %v$84 = load i32, i32* %v$83
   %pipelineVar$7 = call i32 @combine(%Foo* %v$82, i32 %v$84)
   
   
   %v$86 = call i32 @print(i32 %pipelineVar$7)
   
   ret i32 %v$86
}
define i32 @pipeline$6() 
{
   %v$87 = add i32 1, 0
   %v$88 = add i32 1, 0
   %v$89 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$89 to %$$Int$Int$$*
   %v$91 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %v$87, ptr %v$91
   %v$92 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %v$88, ptr %v$92
   
   
   %v$93 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$94 = load i32, i32* %v$93
   %v$95 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$96 = load i32, i32* %v$95
   %v$97 = call i32 @add(i32 %v$94, i32 %v$96)
   
   ret i32 %v$97
}
define i32 @pipeline$7(%Foo* %foo) 
{
   %v$98 = call i32 @pipeline$6()
   %v$99 = call i8* @malloc(i32 12)
   %pipelineVar$9 = bitcast i8* %v$99 to %$$Foo$Int$$*
   %v$101 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$9, i32 0, i32 0
   %v$102 = bitcast ptr %v$101 to i8*
   %v$103 = bitcast ptr %foo to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$102, ptr %v$103, i32 8, i1 0)
   
   %v$104 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$9, i32 0, i32 1
   store i32 %v$98, ptr %v$104
   
   
   %v$105 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$9, i32 0, i32 0
   %v$106 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$9, i32 0, i32 1
   %v$107 = load i32, i32* %v$106
   %pipelineVar$10 = call i32 @combine(%Foo* %v$105, i32 %v$107)
   
   
   %v$109 = call i32 @print(i32 %pipelineVar$10)
   
   ret i32 %v$109
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
