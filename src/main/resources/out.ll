define i32 @main() 
{
   %v$0 = add i32 3, 0
   %v$1 = add i32 5, 0
   %v$2 = mul i32 %v$0, %v$1
   %v$3 = add i32 1, 0
   %a = add i32 %v$2, %v$3
   
   
   %v$5 = add i32 1, 0
   %b = add i32 %a, %v$5
   
   
   
   ret i32 %b
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
