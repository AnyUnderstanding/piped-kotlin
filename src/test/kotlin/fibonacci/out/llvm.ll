define i32 @main() 
{
   %v$0 = add i32 40, 0
   %v$1 = call i32 @pipeLine3(i32 %v$0)
   
   %v$2 = add i32 0, 0
   
   ret i32 %v$2
}
define i32 @fib(i32 %n) 
{
   %v$3 = call i32 @pipeLine12(i32 %n, i32 %n)
   
   ret i32 %v$3
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeLine3(i32 %field0) 
{
   
   %element$1 = call i32 @fib(i32 %field0)
   
   
   %element$2 = call i32 @print(i32 %element$1)
   
   
   
   ret i32 %element$2
}
define i32 @guard0(i32 %x, i32 %n) 
{
   %v$6 = add i32 2, 0
   %v$7 = icmp slt i32 %x, %v$6
   
   br i1 %v$7, label %label0, label %label1
   label0:
   
   ret i32 %n
   label1:
   %v$8 = add i32 1, 0
   %v$9 = sub i32 %x, %v$8
   %v$10 = call i32 @pipeLine7(i32 %v$9)
   %v$11 = add i32 2, 0
   %v$12 = sub i32 %x, %v$11
   %v$13 = call i32 @pipeLine10(i32 %v$12)
   %v$14 = add i32 %v$10, %v$13
   
   ret i32 %v$14
}
define i32 @pipeLine7(i32 %field0) 
{
   
   %element$6 = call i32 @fib(i32 %field0)
   
   
   
   ret i32 %element$6
}
define i32 @pipeLine10(i32 %field0) 
{
   
   %element$9 = call i32 @fib(i32 %field0)
   
   
   
   ret i32 %element$9
}
define i32 @pipeLine12(i32 %field0, i32 %n) 
{
   
   %element$11 = call i32 @guard0(i32 %field0, i32 %n)
   
   
   
   ret i32 %element$11
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
