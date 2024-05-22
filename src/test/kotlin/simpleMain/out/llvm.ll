define i32 @main() 
{
   %v$0 = add i32 1, 0
   %v$1 = add i32 2, 0
   %v$2 = add i32 %v$0, %v$1
   %v$3 = add i32 3, 0
   %v$4 = mul i32 %v$2, %v$3
   %v$5 = call i32 @pipeLine2(i32 %v$4)
   
   %v$6 = add i32 0, 0
   
   ret i32 %v$6
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeLine2(i32 %field0) 
{
   
   %element$1 = call i32 @print(i32 %field0)
   
   
   
   ret i32 %element$1
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
