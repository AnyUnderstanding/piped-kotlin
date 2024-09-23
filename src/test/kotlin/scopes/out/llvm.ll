define i32 @main() 
{
   %a = add i32 1, 0
   
   
   %a = add i32 1, 0
   
   %v$122 = add i32 1, 0
   %b = add i32 2, 0
   
   
   %a = add i32 1, 0
   
   %v$122 = add i32 1, 0
   %b = add i32 2, 0
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %c = call i32 @scope$0(i32 %a, i32 %b)
   
   
   %a = add i32 1, 0
   
   %v$122 = add i32 1, 0
   %b = add i32 2, 0
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %c = call i32 @scope$0(i32 %a, i32 %b)
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %d = call i32 @scope$3()
   
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %v$125 = call i32 @scope$3()
   %v$126 = call i32 @pipeLine0(i32 %d)
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %v$125 = call i32 @scope$3()
   %v$126 = call i32 @pipeLine0(i32 %d)
   %v$127 = add i32 0, 0
   
   ret i32 %v$127
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %v$125 = call i32 @scope$3()
   %v$126 = call i32 @pipeLine0(i32 %d)
   %v$127 = add i32 0, 0
   
   ret i32 %value
}
define i32 @pipeLine0(i32 %field0) 
{
   %a = add i32 1, 0
   
   %v$122 = add i32 1, 0
   %b = add i32 2, 0
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %c = call i32 @scope$0(i32 %a, i32 %b)
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %d = call i32 @scope$3()
   
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %v$125 = call i32 @scope$3()
   %v$126 = call i32 @pipeLine0(i32 %d)
   %v$127 = add i32 0, 0
   %v$128 = call i32 @print(i32 %d)
   
   ret i32 %v$128
}
define i32 @scope$0(i32 %a, i32 %b) 
{
   %a = add i32 1, 0
   
   %v$122 = add i32 1, 0
   %b = add i32 2, 0
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %c = call i32 @scope$0(i32 %a, i32 %b)
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %d = call i32 @scope$3()
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %v$125 = call i32 @scope$3()
   %v$126 = call i32 @pipeLine0(i32 %d)
   %v$127 = add i32 0, 0
   %v$128 = call i32 @print(i32 %d)
   %d = add i32 %a, %b
   
   
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %v$125 = call i32 @scope$3()
   %v$126 = call i32 @pipeLine0(i32 %d)
   %v$127 = add i32 0, 0
   %v$128 = call i32 @print(i32 %d)
   %v$129 = add i32 %a, %b
   
   ret i32 %d
}
define i32 @scope$1(i32 %a, i32 %b, i32 %c) 
{
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %v$125 = call i32 @scope$3()
   %v$126 = call i32 @pipeLine0(i32 %d)
   %v$127 = add i32 0, 0
   %v$128 = call i32 @print(i32 %d)
   %v$129 = add i32 %a, %b
   %v$130 = add i32 %a, %b
   %v$131 = add i32 %v$130, %c
   
   ret i32 %v$131
}
define i32 @scope$2() 
{
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %v$125 = call i32 @scope$3()
   %v$126 = call i32 @pipeLine0(i32 %d)
   %v$127 = add i32 0, 0
   %v$128 = call i32 @print(i32 %d)
   %v$129 = add i32 %a, %b
   %v$130 = add i32 %a, %b
   %v$131 = add i32 %v$130, %c
   %v$132 = call i32 @scope$1(i32 %a, i32 %b, i32 %c)
   
   ret i32 %v$132
}
define i32 @scope$3() 
{
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = call i32 @scope$0(i32 %a, i32 %b)
   %v$125 = call i32 @scope$3()
   %v$126 = call i32 @pipeLine0(i32 %d)
   %v$127 = add i32 0, 0
   %v$128 = call i32 @print(i32 %d)
   %v$129 = add i32 %a, %b
   %v$130 = add i32 %a, %b
   %v$131 = add i32 %v$130, %c
   %v$132 = call i32 @scope$1(i32 %a, i32 %b, i32 %c)
   %v$133 = call i32 @scope$2()
   
   ret i32 %v$133
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
