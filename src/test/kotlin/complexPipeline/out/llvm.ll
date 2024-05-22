%$$Int$Int$$ = type {
   i32,
   i32
}

%$$Int$Int$Int$$ = type {
   i32,
   i32,
   i32
}

define i32 @main() 
{
   %v$0 = add i32 1, 0
   %v$1 = add i32 4, 0
   %v$2 = call i32 @pipeLine4(i32 %v$0, i32 %v$1)
   
   %v$3 = add i32 0, 0
   
   ret i32 %v$3
}
define %$$Int$Int$$* @add(i32 %a, i32 %b) 
{
   %v$4 = add i32 %a, %b
   %v$5 = add i32 1, 0
   %v$6 = call i8* @malloc(i32 8)
   %v$7 = bitcast i8* %v$6 to %$$Int$Int$$*
   %v$8 = getelementptr %$$Int$Int$$, ptr %v$7, i32 0, i32 0
   store i32 %v$4, ptr %v$8
   %v$9 = getelementptr %$$Int$Int$$, ptr %v$7, i32 0, i32 1
   store i32 %v$5, ptr %v$9
   
   ret %$$Int$Int$$* %v$7
}
define %$$Int$Int$$* @test() 
{
   %v$10 = add i32 1, 0
   %v$11 = add i32 2, 0
   %v$12 = call i8* @malloc(i32 8)
   %v$13 = bitcast i8* %v$12 to %$$Int$Int$$*
   %v$14 = getelementptr %$$Int$Int$$, ptr %v$13, i32 0, i32 0
   store i32 %v$10, ptr %v$14
   %v$15 = getelementptr %$$Int$Int$$, ptr %v$13, i32 0, i32 1
   store i32 %v$11, ptr %v$15
   
   ret %$$Int$Int$$* %v$13
}
define i32 @printTuple(i32 %a, i32 %b, i32 %c) 
{
   %v$16 = call i32 @pipeLine7(i32 %a)
   
   %v$17 = call i32 @pipeLine10(i32 %b)
   
   %v$18 = call i32 @pipeLine13(i32 %c)
   
   %v$19 = add i32 0, 0
   
   ret i32 %v$19
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeLine4(i32 %field0, i32 %field1) 
{
   %v$20 = call i8* @malloc(i32 8)
   %element$0 = bitcast i8* %v$20 to %$$Int$Int$$*
   %v$22 = getelementptr %$$Int$Int$$, ptr %element$0, i32 0, i32 0
   store i32 %field0, ptr %v$22
   %v$23 = getelementptr %$$Int$Int$$, ptr %element$0, i32 0, i32 1
   store i32 %field1, ptr %v$23
   
   
   %v$24 = getelementptr %$$Int$Int$$, ptr %element$0, i32 0, i32 0
   %v$25 = load i32, i32* %v$24
   %v$26 = getelementptr %$$Int$Int$$, ptr %element$0, i32 0, i32 1
   %v$27 = load i32, i32* %v$26
   %element$1 = call %$$Int$Int$$* @add(i32 %v$25, i32 %v$27)
   
   
   %v$29 = getelementptr %$$Int$Int$Int$$, ptr %element$1, i32 0, i32 0
   %v$30 = load i32, i32* %v$29
   %v$31 = add i32 3, 0
   %v$32 = getelementptr %$$Int$Int$Int$$, ptr %element$1, i32 0, i32 1
   %v$33 = load i32, i32* %v$32
   %v$34 = call i8* @malloc(i32 12)
   %element$2 = bitcast i8* %v$34 to %$$Int$Int$Int$$*
   %v$36 = getelementptr %$$Int$Int$Int$$, ptr %element$2, i32 0, i32 0
   store i32 %v$30, ptr %v$36
   %v$37 = getelementptr %$$Int$Int$Int$$, ptr %element$2, i32 0, i32 1
   store i32 %v$31, ptr %v$37
   %v$38 = getelementptr %$$Int$Int$Int$$, ptr %element$2, i32 0, i32 2
   store i32 %v$33, ptr %v$38
   
   
   %v$39 = getelementptr %$$Int$Int$Int$$, ptr %element$2, i32 0, i32 0
   %v$40 = load i32, i32* %v$39
   %v$41 = getelementptr %$$Int$Int$Int$$, ptr %element$2, i32 0, i32 1
   %v$42 = load i32, i32* %v$41
   %v$43 = getelementptr %$$Int$Int$Int$$, ptr %element$2, i32 0, i32 2
   %v$44 = load i32, i32* %v$43
   %element$3 = call i32 @printTuple(i32 %v$40, i32 %v$42, i32 %v$44)
   
   
   
   ret i32 %element$3
}
define i32 @pipeLine7(i32 %field0) 
{
   
   %element$6 = call i32 @print(i32 %field0)
   
   
   
   ret i32 %element$6
}
define i32 @pipeLine10(i32 %field0) 
{
   
   %element$9 = call i32 @print(i32 %field0)
   
   
   
   ret i32 %element$9
}
define i32 @pipeLine13(i32 %field0) 
{
   
   %element$12 = call i32 @print(i32 %field0)
   
   
   
   ret i32 %element$12
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
