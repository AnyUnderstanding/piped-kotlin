define i32 @main() 
{
   %v$251 = call i32 @pipeline$17()
   
   %v$252 = add i32 0, 0
   
   ret i32 %v$252
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeline$17() 
{
   %v$253 = add i32 1, 0
   %v$254 = add i32 2, 0
   %v$255 = add i32 %v$253, %v$254
   %v$256 = add i32 3, 0
   %pipelineVar$0 = mul i32 %v$255, %v$256
   
   
   %v$258 = call i32 @print(i32 %pipelineVar$0)
   
   ret i32 %v$258
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
