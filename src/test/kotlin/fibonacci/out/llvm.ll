define i32 @main() 
{
   %v$247 = call i32 @pipeline$13()
   
   %v$248 = add i32 0, 0
   
   ret i32 %v$248
}
define i32 @fib(i32 %n) 
{
   %v$249 = call i32 @pipeline$16(i32 %n)
   
   ret i32 %v$249
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeline$13() 
{
   %pipelineVar$0 = add i32 40, 0
   
   
   %pipelineVar$1 = call i32 @fib(i32 h)
   
   
   %v$252 = call i32 @print(i32 %pipelineVar$1)
   
   ret i32 %v$252
}
define i32 @pipeline$14(i32 %x) 
{
   %v$253 = add i32 1, 0
   %pipelineVar$0 = sub i32 %x, %v$253
   
   
   %v$255 = call i32 @fib(i32 h)
   
   ret i32 %v$255
}
define i32 @pipeline$15(i32 %x) 
{
   %v$256 = add i32 2, 0
   %pipelineVar$0 = sub i32 %x, %v$256
   
   
   %v$258 = call i32 @fib(i32 h)
   
   ret i32 %v$258
}
define i32 @guard$1(i32 %x, i32 %n) 
{
   %v$259 = add i32 2, 0
   %v$260 = icmp slt i32 %x, %v$259
   
   br i1 %v$260, label %label0, label %label1
   label0:
   
   ret i32 %n
   label1:
   %v$261 = call i32 @pipeline$14(i32 %x)
   %v$262 = call i32 @pipeline$15(i32 %x)
   %v$263 = add i32 %v$261, %v$262
   
   ret i32 %v$263
}
define i32 @pipeline$16(i32 %n) 
{
   
   %v$264 = call i32 @guard$1(i32 %n, i32 %n)
   
   ret i32 %v$264
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
