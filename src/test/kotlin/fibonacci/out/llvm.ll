define i32 @main() 
{
   %v$221 = call i32 @pipeline$12()
   
   %v$222 = add i32 0, 0
   
   ret i32 %v$222
}
define i32 @fib(i32 %n) 
{
   %v$223 = call i32 @pipeline$15(i32 %n)
   
   ret i32 %v$223
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeline$12() 
{
   %pipelineVar$0 = add i32 40, 0
   
   
   %pipelineVar$1 = call i32 @fib(i32 %pipelineVar$0)
   
   
   %v$226 = call i32 @print(i32 %pipelineVar$1)
   
   ret i32 %v$226
}
define i32 @pipeline$13(i32 %x) 
{
   %v$227 = add i32 1, 0
   %pipelineVar$0 = sub i32 %x, %v$227
   
   
   %v$229 = call i32 @fib(i32 %pipelineVar$0)
   
   ret i32 %v$229
}
define i32 @pipeline$14(i32 %x) 
{
   %v$230 = add i32 2, 0
   %pipelineVar$0 = sub i32 %x, %v$230
   
   
   %v$232 = call i32 @fib(i32 %pipelineVar$0)
   
   ret i32 %v$232
}
define i32 @guard$1(i32 %x, i32 %n) 
{
   %v$233 = add i32 2, 0
   %v$234 = icmp slt i32 %x, %v$233
   
   br i1 %v$234, label %label0, label %label1
   label0:
   
   ret i32 %n
   label1:
   %v$235 = call i32 @pipeline$13(i32 %x)
   %v$236 = call i32 @pipeline$14(i32 %x)
   %v$237 = add i32 %v$235, %v$236
   
   ret i32 %v$237
}
define i32 @pipeline$15(i32 %n) 
{
   
   %v$238 = call i32 @guard$1(i32 %n, i32 %n)
   
   ret i32 %v$238
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
