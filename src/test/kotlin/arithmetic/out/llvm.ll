define i32 @main() 
{
   %a = add i32 1, 0
   
   
   %v$32 = add i32 1, 0
   %b = add i32 %a, %v$32
   
   
   %c = add i32 %a, %b
   
   
   %v$35 = add i32 %a, %b
   %d = add i32 %v$35, %c
   
   
   %v$37 = add i32 1, 0
   %v$38 = add i32 2, 0
   %v$39 = mul i32 %v$38, %d
   %e = add i32 %v$37, %v$39
   
   
   %v$41 = add i32 1, 0
   %v$42 = add i32 2, 0
   %v$43 = mul i32 %v$42, %e
   %v$44 = add i32 %v$41, %v$43
   %v$45 = add i32 3, 0
   %f = add i32 %v$44, %v$45
   
   
   %v$47 = add i32 2, 0
   %g = sdiv i32 %f, %v$47
   
   
   %v$49 = add i32 2, 0
   %v$50 = add i32 2, 0
   %v$51 = sdiv i32 %g, %v$50
   %h = add i32 %v$49, %v$51
   
   
   %v$53 = call i32 @pipeLine0(i32 %h)
   
   %v$54 = add i32 0, 0
   
   ret i32 %v$54
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeLine0(i32 %field0) 
{
   
   %v$55 = call i32 @print(i32 %h)
   
   ret i32 %v$55
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
