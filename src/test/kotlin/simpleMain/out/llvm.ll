define i32 @main() 
{
   %v$134 = add i32 1, 0
   %v$135 = add i32 2, 0
   %v$136 = add i32 %v$134, %v$135
   %v$137 = add i32 3, 0
   %v$138 = mul i32 %v$136, %v$137
   %v$139 = call i32 @pipeLine0(i32 %v$138)
   
   %v$134 = add i32 1, 0
   %v$135 = add i32 2, 0
   %v$136 = add i32 %v$134, %v$135
   %v$137 = add i32 3, 0
   %v$138 = mul i32 %v$136, %v$137
   %v$139 = call i32 @pipeLine0(i32 %v$138)
   %v$140 = add i32 0, 0
   
   ret i32 %v$140
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   %v$134 = add i32 1, 0
   %v$135 = add i32 2, 0
   %v$136 = add i32 %v$134, %v$135
   %v$137 = add i32 3, 0
   %v$138 = mul i32 %v$136, %v$137
   %v$139 = call i32 @pipeLine0(i32 %v$138)
   %v$140 = add i32 0, 0
   
   ret i32 %value
}
define i32 @pipeLine0(i32 %field0) 
{
   %v$134 = add i32 1, 0
   %v$135 = add i32 2, 0
   %v$136 = add i32 %v$134, %v$135
   %v$137 = add i32 3, 0
   %v$138 = mul i32 %v$136, %v$137
   %v$139 = call i32 @pipeLine0(i32 %v$138)
   %v$140 = add i32 0, 0
   %v$141 = add i32 1, 0
   %v$142 = add i32 2, 0
   %v$143 = add i32 %v$141, %v$142
   %v$144 = add i32 3, 0
   %pipeLineVar0 = mul i32 %v$143, %v$144
   
   
   %v$134 = add i32 1, 0
   %v$135 = add i32 2, 0
   %v$136 = add i32 %v$134, %v$135
   %v$137 = add i32 3, 0
   %v$138 = mul i32 %v$136, %v$137
   %v$139 = call i32 @pipeLine0(i32 %v$138)
   %v$140 = add i32 0, 0
   %v$141 = add i32 1, 0
   %v$142 = add i32 2, 0
   %v$143 = add i32 %v$141, %v$142
   %v$144 = add i32 3, 0
   %v$145 = mul i32 %v$143, %v$144
   %v$146 = call i32 @print(i32 %pipeLineVar0)
   
   ret i32 %v$146
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
