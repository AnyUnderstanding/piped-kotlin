define i32 @main() 
{
   %a = add i32 1, 0
   
   
   %b = add i32 2, 0
   
   
   %c = call i32 @scope$0(i32 %a, i32 %b)
   
   
   %d = call i32 @scope$3()
   
   
   %v$243 = call i32 @pipeline$16(i32 %d)
   
   %v$244 = add i32 0, 0
   
   ret i32 %v$244
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeline$16(i32 %d) 
{
   
   %v$245 = call i32 @print(i32 %d)
   
   ret i32 %v$245
}
define i32 @scope$0(i32 %a, i32 %b) 
{
   %d = add i32 %a, %b
   
   
   
   ret i32 %d
}
define i32 @scope$1(i32 %a, i32 %b, i32 %c) 
{
   %v$247 = add i32 %a, %b
   %v$248 = add i32 %v$247, %c
   
   ret i32 %v$248
}
define i32 @scope$2() 
{
   %v$249 = call i32 @scope$1(i32 %a, i32 %b, i32 %c)
   
   ret i32 %v$249
}
define i32 @scope$3() 
{
   %v$250 = call i32 @scope$2()
   
   ret i32 %v$250
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
