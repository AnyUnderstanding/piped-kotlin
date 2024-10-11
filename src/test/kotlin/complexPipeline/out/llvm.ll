%Foo = type {
   i32
}

%$$Int$Int$$ = type {
   i32,
   i32
}

%$$Int$Int$Int$$ = type {
   i32,
   i32,
   i32
}

define i32 @main() 
{
   %v$81 = add i32 42, 0
   %v$82 = call i8* @malloc(i32 4)
   %foo = bitcast i8* %v$82 to %Foo*
   %v$84 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   store i32 %v$81, ptr %v$84
   
   
   %v$85 = call i32 @pipeline$6()
   
   %v$86 = call i32 @pipeline$7()
   
   %v$87 = call i32 @pipeline$8()
   
   %v$88 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$89 = load i32, i32* %v$88
   %v$90 = call i32 @pipeline$9(i32 %v$89)
   
   %v$91 = add i32 0, 0
   
   ret i32 %v$91
}
define i32 @add(i32 %a, i32 %b) 
{
   %v$92 = add i32 %a, %b
   
   ret i32 %v$92
}
define i32 @printTuple(i32 %a, i32 %b) 
{
   %v$93 = call i32 @pipeline$10(i32 %a)
   
   %v$94 = call i32 @pipeline$11(i32 %b)
   
   %v$95 = add i32 3141, 0
   
   ret i32 %v$95
}
define i32 @id(i32 %elem) 
{
   
   ret i32 %elem
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeline$6() 
{
   %v$96 = add i32 1, 0
   %v$97 = add i32 4, 0
   %v$98 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$98 to %$$Int$Int$$*
   %v$100 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %v$96, ptr %v$100
   %v$101 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %v$97, ptr %v$101
   
   
   %v$102 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$103 = load i32, i32* %v$102
   %v$104 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$105 = load i32, i32* %v$104
   %pipelineVar$1 = call i32 @add(i32 %v$103, i32 %v$105)
   
   
   %v$107 = add i32 3, 0
   %v$108 = call i8* @malloc(i32 8)
   %pipelineVar$2 = bitcast i8* %v$108 to %$$Int$Int$$*
   %v$110 = getelementptr %$$Int$Int$$, ptr %pipelineVar$2, i32 0, i32 0
   store i32 %pipelineVar$1, ptr %v$110
   %v$111 = getelementptr %$$Int$Int$$, ptr %pipelineVar$2, i32 0, i32 1
   store i32 %v$107, ptr %v$111
   
   
   %v$112 = getelementptr %$$Int$Int$$, ptr %pipelineVar$2, i32 0, i32 0
   %v$113 = load i32, i32* %v$112
   %v$114 = getelementptr %$$Int$Int$$, ptr %pipelineVar$2, i32 0, i32 1
   %v$115 = load i32, i32* %v$114
   %pipelineVar$3 = call i32 @printTuple(i32 %v$113, i32 %v$115)
   
   
   %pipelineVar$4 = call i32 @id(i32 %pipelineVar$3)
   
   
   
   %pipelineVar$6 = call i32 @id(i32 %pipelineVar$4)
   
   
   %v$119 = call i32 @print(i32 %pipelineVar$6)
   
   ret i32 %v$119
}
define i32 @pipeline$7() 
{
   %pipelineVar$8 = add i32 1, 0
   
   
   %v$121 = call i8* @malloc(i32 8)
   %pipelineVar$9 = bitcast i8* %v$121 to %$$Int$Int$$*
   %v$123 = getelementptr %$$Int$Int$$, ptr %pipelineVar$9, i32 0, i32 0
   store i32 %pipelineVar$8, ptr %v$123
   %v$124 = getelementptr %$$Int$Int$$, ptr %pipelineVar$9, i32 0, i32 1
   store i32 %pipelineVar$8, ptr %v$124
   
   
   %v$125 = getelementptr %$$Int$Int$$, ptr %pipelineVar$9, i32 0, i32 0
   %v$126 = load i32, i32* %v$125
   %v$127 = getelementptr %$$Int$Int$$, ptr %pipelineVar$9, i32 0, i32 1
   %v$128 = load i32, i32* %v$127
   %v$129 = call i32 @printTuple(i32 %v$126, i32 %v$128)
   
   ret i32 %v$129
}
define i32 @pipeline$8() 
{
   %v$130 = add i32 1, 0
   %v$131 = add i32 2, 0
   %v$132 = add i32 3, 0
   %v$133 = call i8* @malloc(i32 12)
   %pipelineVar$11 = bitcast i8* %v$133 to %$$Int$Int$Int$$*
   %v$135 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 0
   store i32 %v$130, ptr %v$135
   %v$136 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 1
   store i32 %v$131, ptr %v$136
   %v$137 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 2
   store i32 %v$132, ptr %v$137
   
   
   %v$138 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 2
   %v$139 = load i32, i32* %v$138
   %v$140 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 1
   %v$141 = load i32, i32* %v$140
   %v$142 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 0
   %v$143 = load i32, i32* %v$142
   %v$144 = call i8* @malloc(i32 12)
   %pipelineVar$12 = bitcast i8* %v$144 to %$$Int$Int$Int$$*
   %v$146 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$12, i32 0, i32 0
   store i32 %v$139, ptr %v$146
   %v$147 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$12, i32 0, i32 1
   store i32 %v$141, ptr %v$147
   %v$148 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$12, i32 0, i32 2
   store i32 %v$143, ptr %v$148
   
   
   %v$149 = getelementptr %$$Int$Int$$, ptr %pipelineVar$12, i32 0, i32 1
   %v$150 = load i32, i32* %v$149
   %v$151 = getelementptr %$$Int$Int$$, ptr %pipelineVar$12, i32 0, i32 0
   %v$152 = load i32, i32* %v$151
   %v$153 = call i8* @malloc(i32 8)
   %pipelineVar$13 = bitcast i8* %v$153 to %$$Int$Int$$*
   %v$155 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 0
   store i32 %v$150, ptr %v$155
   %v$156 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 1
   store i32 %v$152, ptr %v$156
   
   
   %v$157 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 0
   %v$158 = load i32, i32* %v$157
   %v$159 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 1
   %v$160 = load i32, i32* %v$159
   %v$161 = call i32 @printTuple(i32 %v$158, i32 %v$160)
   
   ret i32 %v$161
}
define %$$Int$Int$$* @guard$0(i32 %x, i32 %y, i32 %foo$bar) 
{
   %v$162 = mul i32 %x, %y
   %v$163 = add i32 0, 0
   %v$164 = icmp eq i32 %v$162, %v$163
   
   br i1 %v$164, label %label0, label %label1
   label0:
   %v$165 = add i32 0, 0
   %v$166 = add i32 0, 0
   %v$167 = call i8* @malloc(i32 8)
   %v$168 = bitcast i8* %v$167 to %$$Int$Int$$*
   %v$169 = getelementptr %$$Int$Int$$, ptr %v$168, i32 0, i32 0
   store i32 %v$165, ptr %v$169
   %v$170 = getelementptr %$$Int$Int$$, ptr %v$168, i32 0, i32 1
   store i32 %v$166, ptr %v$170
   
   ret %$$Int$Int$$* %v$168
   label1:
   %v$171 = mul i32 %x, %y
   %v$172 = add i32 0, 0
   %v$173 = icmp sgt i32 %v$171, %v$172
   
   br i1 %v$173, label %label2, label %label3
   label2:
   %v$174 = add i32 1, 0
   %v$175 = add i32 2, 0
   %v$176 = call i8* @malloc(i32 8)
   %v$177 = bitcast i8* %v$176 to %$$Int$Int$$*
   %v$178 = getelementptr %$$Int$Int$$, ptr %v$177, i32 0, i32 0
   store i32 %v$174, ptr %v$178
   %v$179 = getelementptr %$$Int$Int$$, ptr %v$177, i32 0, i32 1
   store i32 %v$175, ptr %v$179
   
   ret %$$Int$Int$$* %v$177
   label3:
   %v$180 = add i32 3, 0
   %v$181 = add i32 4, 0
   %v$182 = call i8* @malloc(i32 8)
   %v$183 = bitcast i8* %v$182 to %$$Int$Int$$*
   %v$184 = getelementptr %$$Int$Int$$, ptr %v$183, i32 0, i32 0
   store i32 %v$180, ptr %v$184
   %v$185 = getelementptr %$$Int$Int$$, ptr %v$183, i32 0, i32 1
   store i32 %v$181, ptr %v$185
   
   ret %$$Int$Int$$* %v$183
}
define i32 @pipeline$9(i32 %foo$bar) 
{
   %v$186 = add i32 1, 0
   %v$187 = call i8* @malloc(i32 8)
   %pipelineVar$15 = bitcast i8* %v$187 to %$$Int$Int$$*
   %v$189 = getelementptr %$$Int$Int$$, ptr %pipelineVar$15, i32 0, i32 0
   store i32 %v$186, ptr %v$189
   %v$190 = getelementptr %$$Int$Int$$, ptr %pipelineVar$15, i32 0, i32 1
   store i32 %foo$bar, ptr %v$190
   
   
   %v$191 = getelementptr %$$Int$Int$$, ptr %pipelineVar$15, i32 0, i32 1
   %v$192 = load i32, i32* %v$191
   %v$193 = add i32 1, 0
   %v$194 = add i32 %foo$bar, %v$193
   %v$195 = call i8* @malloc(i32 8)
   %pipelineVar$16 = bitcast i8* %v$195 to %$$Int$Int$$*
   %v$197 = getelementptr %$$Int$Int$$, ptr %pipelineVar$16, i32 0, i32 0
   store i32 %v$192, ptr %v$197
   %v$198 = getelementptr %$$Int$Int$$, ptr %pipelineVar$16, i32 0, i32 1
   store i32 %v$194, ptr %v$198
   
   
   %v$199 = getelementptr %$$Int$Int$$, ptr %pipelineVar$16, i32 0, i32 0
   %v$200 = load i32, i32* %v$199
   %v$201 = getelementptr %$$Int$Int$$, ptr %pipelineVar$16, i32 0, i32 1
   %v$202 = load i32, i32* %v$201
   %pipelineVar$17 = call i32 @printTuple(i32 %v$200, i32 %v$202)
   
   
   %v$204 = add i32 10, 0
   %v$205 = call i8* @malloc(i32 8)
   %pipelineVar$18 = bitcast i8* %v$205 to %$$Int$Int$$*
   %v$207 = getelementptr %$$Int$Int$$, ptr %pipelineVar$18, i32 0, i32 0
   store i32 %pipelineVar$17, ptr %v$207
   %v$208 = getelementptr %$$Int$Int$$, ptr %pipelineVar$18, i32 0, i32 1
   store i32 %v$204, ptr %v$208
   
   
   %v$209 = getelementptr %$$Int$Int$$, ptr %pipelineVar$18, i32 0, i32 0
   %v$210 = load i32, i32* %v$209
   %v$211 = getelementptr %$$Int$Int$$, ptr %pipelineVar$18, i32 0, i32 1
   %v$212 = load i32, i32* %v$211
   %pipelineVar$19 = call %$$Int$Int$$* @guard$0(i32 %v$210, i32 %v$212, i32 %foo$bar)
   
   
   %v$214 = getelementptr %$$Int$Int$$, ptr %pipelineVar$19, i32 0, i32 0
   %v$215 = load i32, i32* %v$214
   %v$216 = getelementptr %$$Int$Int$$, ptr %pipelineVar$19, i32 0, i32 1
   %v$217 = load i32, i32* %v$216
   %v$218 = call i32 @printTuple(i32 %v$215, i32 %v$217)
   
   ret i32 %v$218
}
define i32 @pipeline$10(i32 %a) 
{
   
   %v$219 = call i32 @print(i32 %a)
   
   ret i32 %v$219
}
define i32 @pipeline$11(i32 %b) 
{
   
   %v$220 = call i32 @print(i32 %b)
   
   ret i32 %v$220
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
