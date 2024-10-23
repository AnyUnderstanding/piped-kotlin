define i32 @main() 
{
   %v$277 = call i32 @pipeline$18()
   
   %v$278 = add i32 0, 0
   
   ret i32 %v$278
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeline$18() 
{
   %v$279 = add i32 1, 0
   %v$280 = add i32 2, 0
   %v$281 = add i32 %v$279, %v$280
   %v$282 = add i32 3, 0
   %pipelineVar$0 = mul i32 %v$281, %v$282
   
   
   %v$284 = call i32 @print(i32 d)
   
   ret i32 %v$284
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
