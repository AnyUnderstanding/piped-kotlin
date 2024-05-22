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
   %v$0 = add i32 5, 0
   %foo = call %Foo* @pipeLine2(i32 %v$0)
   
   
   %v$2 = add i32 3, 0
   %foo2 = call %Foo* @pipeLine5(i32 %v$2)
   
   
   %v$4 = getelementptr %Foo, ptr %foo, i32 0, i32 0, i32 0, i32 0
   %v$5 = load i32, i32* %v$4
   %v$6 = add i32 3, 0
   %v$7 = mul i32 %v$5, %v$6
   %v$8 = getelementptr %Foo, ptr %foo2, i32 0, i32 0, i32 0, i32 0
   %v$9 = load i32, i32* %v$8
   %v$10 = add i32 %v$7, %v$9
   %v$11 = getelementptr %Foo, ptr %foo2, i32 0, i32 0, i32 0, i32 0
   %v$12 = load i32, i32* %v$11
   %v$13 = add i32 1, 0
   %v$14 = add i32 %v$12, %v$13
   %human = call %Human* @pipeLine8(i32 %v$10, i32 %v$14)
   
   
   %v$16 = getelementptr %Human, ptr %human, i32 0, i32 0
   %v$17 = load i32, i32* %v$16
   %v$18 = call i32 @pipeLine11(i32 %v$17)
   
   %v$19 = getelementptr %Human, ptr %human, i32 0, i32 1, i32 0
   %v$20 = load i32, i32* %v$19
   %v$21 = call i32 @pipeLine14(i32 %v$20)
   
   %v$22 = add i32 0, 0
   
   ret i32 %v$22
}
define %Foo* @getFoo(i32 %x) 
{
   %v$23 = call i8* @malloc(i32 4)
   %baz = bitcast i8* %v$23 to %Baz*
   %v$25 = getelementptr %Baz, ptr %baz, i32 0, i32 0
   store i32 %x, ptr %v$25
   
   
   %v$26 = call i8* @malloc(i32 4)
   %bar = bitcast i8* %v$26 to %Bar*
   %v$28 = getelementptr %Bar, ptr %bar, i32 0, i32 0
   %v$29 = bitcast ptr %v$28 to i8*
   %v$30 = bitcast ptr %baz to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$29, ptr %v$30, i32 4, i1 0)
   
   
   
   %v$31 = call i8* @malloc(i32 4)
   %foo = bitcast i8* %v$31 to %Foo*
   %v$33 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$34 = bitcast ptr %v$33 to i8*
   %v$35 = bitcast ptr %bar to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$34, ptr %v$35, i32 4, i1 0)
   
   
   
   
   ret %Foo* %foo
}
define %Human* @getHuman(i32 %hAge, i32 %dAge) 
{
   %v$36 = call i8* @malloc(i32 4)
   %dog = bitcast i8* %v$36 to %Dog*
   %v$38 = getelementptr %Dog, ptr %dog, i32 0, i32 0
   store i32 %dAge, ptr %v$38
   
   
   %v$39 = call i8* @malloc(i32 8)
   %human = bitcast i8* %v$39 to %Human*
   %v$41 = getelementptr %Human, ptr %human, i32 0, i32 0
   store i32 %hAge, ptr %v$41
   %v$42 = getelementptr %Human, ptr %human, i32 0, i32 1
   %v$43 = bitcast ptr %v$42 to i8*
   %v$44 = bitcast ptr %dog to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$43, ptr %v$44, i32 4, i1 0)
   
   
   
   
   ret %Human* %human
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define %Foo* @pipeLine2(i32 %field0) 
{
   
   %element$1 = call %Foo* @getFoo(i32 %field0)
   
   
   
   ret %Foo* %element$1
}
define %Foo* @pipeLine5(i32 %field0) 
{
   
   %element$4 = call %Foo* @getFoo(i32 %field0)
   
   
   
   ret %Foo* %element$4
}
define %Human* @pipeLine8(i32 %field0, i32 %field1) 
{
   %v$47 = call i8* @malloc(i32 8)
   %element$6 = bitcast i8* %v$47 to %$$Int$Int$$*
   %v$49 = getelementptr %$$Int$Int$$, ptr %element$6, i32 0, i32 0
   store i32 %field0, ptr %v$49
   %v$50 = getelementptr %$$Int$Int$$, ptr %element$6, i32 0, i32 1
   store i32 %field1, ptr %v$50
   
   
   %v$51 = getelementptr %$$Int$Int$$, ptr %element$6, i32 0, i32 0
   %v$52 = load i32, i32* %v$51
   %v$53 = getelementptr %$$Int$Int$$, ptr %element$6, i32 0, i32 1
   %v$54 = load i32, i32* %v$53
   %element$7 = call %Human* @getHuman(i32 %v$52, i32 %v$54)
   
   
   
   ret %Human* %element$7
}
define i32 @pipeLine11(i32 %field0) 
{
   
   %element$10 = call i32 @print(i32 %field0)
   
   
   
   ret i32 %element$10
}
define i32 @pipeLine14(i32 %field0) 
{
   
   %element$13 = call i32 @print(i32 %field0)
   
   
   
   ret i32 %element$13
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
