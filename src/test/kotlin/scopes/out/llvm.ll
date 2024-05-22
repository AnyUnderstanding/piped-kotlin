define i32 @main() 
{
   %a = add i32 1, 0
   
   
   %b = add i32 2, 0
   
   
   %c = call i32 @scope$0(i32 %a, i32 %b)
   
   
   %d = call i32 @scope$3()
   
   
   %v$4 = call i32 @pipeLine2(i32 %d)
   
   %v$5 = add i32 0, 0
   
   ret i32 %v$5
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
define i32 @scope$0(i32 %a, i32 %b) 
{
   %d = add i32 %a, %b
   
   
   
   ret i32 %d
}
define i32 @scope$1(i32 %a, i32 %b, i32 %c) 
{
   %v$8 = add i32 %a, %b
   %v$9 = add i32 %v$8, %c
   
   ret i32 %v$9
}
define i32 @scope$2() 
{
   %v$10 = call i32 @scope$1(i32 %a, i32 %b, i32 %c)
   
   ret i32 %v$10
}
define i32 @scope$3() 
{
   %v$11 = call i32 @scope$2()
   
   ret i32 %v$11
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
