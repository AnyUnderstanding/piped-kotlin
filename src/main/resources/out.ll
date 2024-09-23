%$$Int$Int$$ = type {
   i32,
   i32
}

define i1 @main() 
{
   %v$0 = add i32 3, 0
   %v$1 = add i32 4, 0
   %v$2 = call i1 @pipeLine0(i32 %v$0, i32 %v$1)
   
   ret i1 %v$2
}
define i1 @isPrimeAux(i32 %i, i32 %n) 
{
   %v$0 = add i32 3, 0
   %v$1 = add i32 4, 0
   %v$2 = call i1 @pipeLine0(i32 %v$0, i32 %v$1)
   %v$3 = add i1 false, 0
   
   ret i1 %v$3
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   %v$0 = add i32 3, 0
   %v$1 = add i32 4, 0
   %v$2 = call i1 @pipeLine0(i32 %v$0, i32 %v$1)
   %v$3 = add i1 false, 0
   
   ret i32 %value
}
define i1 @pipeLine0(i32 %field0, i32 %field1) 
{
   %v$0 = add i32 3, 0
   %v$1 = add i32 4, 0
   %v$2 = call i1 @pipeLine0(i32 %v$0, i32 %v$1)
   %v$3 = add i1 false, 0
   %v$4 = add i32 3, 0
   %v$5 = add i32 4, 0
   %v$6 = call i8* @malloc(i32 8)
   %pipeLineVar0 = bitcast i8* %v$6 to %$$Int$Int$$*
   %v$8 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   store i32 %v$4, ptr %v$8
   %v$9 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   store i32 %v$5, ptr %v$9
   
   
   %v$0 = add i32 3, 0
   %v$1 = add i32 4, 0
   %v$2 = call i1 @pipeLine0(i32 %v$0, i32 %v$1)
   %v$3 = add i1 false, 0
   %v$4 = add i32 3, 0
   %v$5 = add i32 4, 0
   %v$6 = call i8* @malloc(i32 8)
   %v$7 = bitcast i8* %v$6 to %$$Int$Int$$*
   %v$8 = getelementptr %$$Int$Int$$, ptr %v$7, i32 0, i32 0
   store i32 %v$4, ptr %v$8
   %v$9 = getelementptr %$$Int$Int$$, ptr %v$7, i32 0, i32 1
   store i32 %v$5, ptr %v$9
   %v$10 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 0
   %v$11 = load i32, i32* %v$10
   %v$12 = getelementptr %$$Int$Int$$, ptr %pipeLineVar0, i32 0, i32 1
   %v$13 = load i32, i32* %v$12
   %v$14 = call i1 @isPrimeAux(i32 %v$11, i32 %v$13)
   
   ret i1 %v$14
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
