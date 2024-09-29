define i32 @main() 
{
   %a = add i32 1, 0
   
   
   %v$15 = add i32 1, 0
   %b = add i32 %a, %v$15
   
   
   %c = add i32 %a, %b
   
   
   %v$18 = add i32 %a, %b
   %d = add i32 %v$18, %c
   
   
   %v$20 = add i32 1, 0
   %v$21 = add i32 2, 0
   %v$22 = mul i32 %v$21, %d
   %e = add i32 %v$20, %v$22
   
   
   %v$24 = add i32 1, 0
   %v$25 = add i32 2, 0
   %v$26 = mul i32 %v$25, %e
   %v$27 = add i32 %v$24, %v$26
   %v$28 = add i32 3, 0
   %f = add i32 %v$27, %v$28
   
   
   %v$30 = add i32 2, 0
   %g = sdiv i32 %f, %v$30
   
   
   %v$32 = add i32 2, 0
   %v$33 = add i32 2, 0
   %v$34 = sdiv i32 %g, %v$33
   %h = add i32 %v$32, %v$34
   
   
   %v$36 = call i32 @pipeLine$0(i32 %h)
   
   %v$37 = add i32 0, 0
   
   ret i32 %v$37
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeLine$0(i32 %field$0) 
{
   
   %v$38 = call i32 @print(i32 %pipeLineVar$-1)
   
   ret i32 %v$38
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
