define i32 @main() 
{
   %a = add i32 1, 0
   
   
   %v$27 = add i32 1, 0
   %b = add i32 %a, %v$27
   
   
   %c = add i32 %a, %b
   
   
   %v$30 = add i32 %a, %b
   %d = add i32 %v$30, %c
   
   
   %v$32 = add i32 1, 0
   %v$33 = add i32 2, 0
   %v$34 = mul i32 %v$33, %d
   %e = add i32 %v$32, %v$34
   
   
   %v$36 = add i32 1, 0
   %v$37 = add i32 2, 0
   %v$38 = mul i32 %v$37, %e
   %v$39 = add i32 %v$36, %v$38
   %v$40 = add i32 3, 0
   %f = add i32 %v$39, %v$40
   
   
   %v$42 = add i32 2, 0
   %g = sdiv i32 %f, %v$42
   
   
   %v$44 = add i32 2, 0
   %v$45 = add i32 2, 0
   %v$46 = sdiv i32 %g, %v$45
   %h = add i32 %v$44, %v$46
   
   
   %v$48 = call i32 @pipeline$1(i32 %h)
   
   %v$49 = add i32 0, 0
   
   ret i32 %v$49
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeline$1(i32 %h) 
{
   
   %v$50 = call i32 @print(i32 %h)
   
   ret i32 %v$50
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
