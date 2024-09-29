%$$Int$Int$$ = type {
   i32,
   i32
}

define i32 @main() 
{
   %v$0 = add i32 1, 0
   %v$1 = add i32 4, 0
   %v$2 = call i32 @pipeLine0(i32 %v$0, i32 %v$1)
   
   %v$3 = add i32 0, 0
   
   ret i32 %v$3
}
define i32 @add(i32 %a, i32 %b) 
{
   %v$4 = add i32 %a, %b
   
   ret i32 %v$4
}
define i32 @printTuple(i32 %a, i32 %b) 
{
   %v$5 = call i32 @pipeLine1(i32 %a)
   
   %v$6 = call i32 @pipeLine2(i32 %b)
   
   %v$7 = add i32 0, 0
   
   ret i32 %v$7
}
define i32 @id(i32 %elem) 
{
   
   ret i32 %elem
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeLine0(i32 %field0, i32 %field1) 
{
   %v$8 = add i32 1, 0
   %v$9 = add i32 4, 0
   %v$10 = call i8* @malloc(i32 8)
   %pipeLineVar0 = bitcast i8* %v$10 to %$$Int$Int$$*
   %v$12 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   store i32 %v$8, ptr %v$12
   %v$13 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   store i32 %v$9, ptr %v$13
   
   
   %v$14 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$15 = load i32, i32* %v$14
   %v$16 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$17 = load i32, i32* %v$16
   %pipeLineVar1 = call i32 @add(i32 %v$15, i32 %v$17)
   
   
   %v$19 = add i32 3, 0
   %v$20 = call i8* @malloc(i32 8)
   %pipeLineVar2 = bitcast i8* %v$20 to %$$Int$Int$$*
   %v$22 = getelementptr %$$Int$Int$$, ptr %pipeLineVar2, i32 0, i32 0
   store i32 %pipeLineVar1, ptr %v$22
   %v$23 = getelementptr %$$Int$Int$$, ptr %pipeLineVar2, i32 0, i32 1
   store i32 %v$19, ptr %v$23
   
   
   %v$24 = getelementptr %$$Int$Int$$, ptr %pipeLineVar2, i32 0, i32 0
   %v$25 = load i32, i32* %v$24
   %v$26 = getelementptr %$$Int$Int$$, ptr %pipeLineVar2, i32 0, i32 1
   %v$27 = load i32, i32* %v$26
   %pipeLineVar3 = call i32 @printTuple(i32 %v$25, i32 %v$27)
   
   
   %pipeLineVar4 = call i32 @id(i32 %pipeLineVar3)
   
   
   
   %pipeLineVar6 = call i32 @id(i32 %field0)
   
   
   %v$31 = call i32 @print(i32 %pipeLineVar6)
   
   ret i32 %v$31
}
define i32 @pipeLine1(i32 %field0) 
{
   
   %v$32 = call i32 @print(i32 %field0)
   
   ret i32 %v$32
}
define i32 @pipeLine2(i32 %field0) 
{
   
   %v$33 = call i32 @print(i32 %field0)
   
   ret i32 %v$33
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
