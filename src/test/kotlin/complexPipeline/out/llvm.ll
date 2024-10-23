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
   %v$107 = add i32 42, 0
   %v$108 = call i8* @malloc(i32 4)
   %foo = bitcast i8* %v$108 to %Foo*
   %v$110 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   store i32 %v$107, ptr %v$110
   
   
   %v$111 = call i32 @pipeline$7()
   
   %v$112 = call i32 @pipeline$8()
   
   %v$113 = call i32 @pipeline$9()
   
   %v$114 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$115 = load i32, i32* %v$114
   %v$116 = call i32 @pipeline$10(i32 %v$115)
   
   %v$117 = add i32 0, 0
   
   ret i32 %v$117
}
define i32 @add(i32 %a, i32 %b) 
{
   %v$118 = add i32 %a, %b
   
   ret i32 %v$118
}
define i32 @printTuple(i32 %a, i32 %b) 
{
   %v$119 = call i32 @pipeline$11(i32 %a)
   
   %v$120 = call i32 @pipeline$12(i32 %b)
   
   %v$121 = add i32 3141, 0
   
   ret i32 %v$121
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
define i32 @pipeline$7() 
{
   %v$122 = add i32 1, 0
   %v$123 = add i32 4, 0
   %v$124 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$124 to %$$Int$Int$$*
   %v$126 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %v$122, ptr %v$126
   %v$127 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %v$123, ptr %v$127
   
   
   %v$128 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$129 = load i32, i32* %v$128
   %v$130 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$131 = load i32, i32* %v$130
   %pipelineVar$1 = call i32 @add(i32 %v$129, i32 %v$131)
   
   
   %v$133 = add i32 3, 0
   %v$134 = call i8* @malloc(i32 8)
   %pipelineVar$2 = bitcast i8* %v$134 to %$$Int$Int$$*
   %v$136 = getelementptr %$$Int$Int$$, ptr %pipelineVar$2, i32 0, i32 0
   store i32 %pipelineVar$1, ptr %v$136
   %v$137 = getelementptr %$$Int$Int$$, ptr %pipelineVar$2, i32 0, i32 1
   store i32 %v$133, ptr %v$137
   
   
   %v$138 = getelementptr %$$Int$Int$$, ptr %pipelineVar$2, i32 0, i32 0
   %v$139 = load i32, i32* %v$138
   %v$140 = getelementptr %$$Int$Int$$, ptr %pipelineVar$2, i32 0, i32 1
   %v$141 = load i32, i32* %v$140
   %pipelineVar$3 = call i32 @printTuple(i32 %v$139, i32 %v$141)
   
   
   %pipelineVar$4 = call i32 @id(i32 %pipelineVar$3)
   
   
   
   %pipelineVar$6 = call i32 @id(i32 %pipelineVar$4)
   
   
   %v$145 = call i32 @print(i32 human$age)
   
   ret i32 %v$145
}
define i32 @pipeline$8() 
{
   %pipelineVar$8 = add i32 1, 0
   
   
   %v$147 = call i8* @malloc(i32 8)
   %pipelineVar$9 = bitcast i8* %v$147 to %$$Int$Int$$*
   %v$149 = getelementptr %$$Int$Int$$, ptr %pipelineVar$9, i32 0, i32 0
   store i32 %pipelineVar$8, ptr %v$149
   %v$150 = getelementptr %$$Int$Int$$, ptr %pipelineVar$9, i32 0, i32 1
   store i32 %pipelineVar$8, ptr %v$150
   
   
   %v$151 = getelementptr %$$Int$Int$$, ptr %pipelineVar$9, i32 0, i32 0
   %v$152 = load i32, i32* %v$151
   %v$153 = getelementptr %$$Int$Int$$, ptr %pipelineVar$9, i32 0, i32 1
   %v$154 = load i32, i32* %v$153
   %v$155 = call i32 @printTuple(i32 %v$152, i32 %v$154)
   
   ret i32 %v$155
}
define i32 @pipeline$9() 
{
   %v$156 = add i32 1, 0
   %v$157 = add i32 2, 0
   %v$158 = add i32 3, 0
   %v$159 = call i8* @malloc(i32 12)
   %pipelineVar$11 = bitcast i8* %v$159 to %$$Int$Int$Int$$*
   %v$161 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 0
   store i32 %v$156, ptr %v$161
   %v$162 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 1
   store i32 %v$157, ptr %v$162
   %v$163 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 2
   store i32 %v$158, ptr %v$163
   
   
   %v$164 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 2
   %v$165 = load i32, i32* %v$164
   %v$166 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 1
   %v$167 = load i32, i32* %v$166
   %v$168 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$11, i32 0, i32 0
   %v$169 = load i32, i32* %v$168
   %v$170 = call i8* @malloc(i32 12)
   %pipelineVar$12 = bitcast i8* %v$170 to %$$Int$Int$Int$$*
   %v$172 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$12, i32 0, i32 0
   store i32 %v$165, ptr %v$172
   %v$173 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$12, i32 0, i32 1
   store i32 %v$167, ptr %v$173
   %v$174 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$12, i32 0, i32 2
   store i32 %v$169, ptr %v$174
   
   
   %v$175 = getelementptr %$$Int$Int$$, ptr %pipelineVar$12, i32 0, i32 1
   %v$176 = load i32, i32* %v$175
   %v$177 = getelementptr %$$Int$Int$$, ptr %pipelineVar$12, i32 0, i32 0
   %v$178 = load i32, i32* %v$177
   %v$179 = call i8* @malloc(i32 8)
   %pipelineVar$13 = bitcast i8* %v$179 to %$$Int$Int$$*
   %v$181 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 0
   store i32 %v$176, ptr %v$181
   %v$182 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 1
   store i32 %v$178, ptr %v$182
   
   
   %v$183 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 0
   %v$184 = load i32, i32* %v$183
   %v$185 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 1
   %v$186 = load i32, i32* %v$185
   %v$187 = call i32 @printTuple(i32 %v$184, i32 %v$186)
   
   ret i32 %v$187
}
define %$$Int$Int$$* @guard$0(i32 %x, i32 %y, i32 %foo$bar) 
{
   %v$188 = mul i32 %x, %y
   %v$189 = add i32 0, 0
   %v$190 = icmp eq i32 %v$188, %v$189
   
   br i1 %v$190, label %label0, label %label1
   label0:
   %v$191 = add i32 0, 0
   %v$192 = add i32 0, 0
   %v$193 = call i8* @malloc(i32 8)
   %v$194 = bitcast i8* %v$193 to %$$Int$Int$$*
   %v$195 = getelementptr %$$Int$Int$$, ptr %v$194, i32 0, i32 0
   store i32 %v$191, ptr %v$195
   %v$196 = getelementptr %$$Int$Int$$, ptr %v$194, i32 0, i32 1
   store i32 %v$192, ptr %v$196
   
   ret %$$Int$Int$$* %v$194
   label1:
   %v$197 = mul i32 %x, %y
   %v$198 = add i32 0, 0
   %v$199 = icmp sgt i32 %v$197, %v$198
   
   br i1 %v$199, label %label2, label %label3
   label2:
   %v$200 = add i32 1, 0
   %v$201 = add i32 2, 0
   %v$202 = call i8* @malloc(i32 8)
   %v$203 = bitcast i8* %v$202 to %$$Int$Int$$*
   %v$204 = getelementptr %$$Int$Int$$, ptr %v$203, i32 0, i32 0
   store i32 %v$200, ptr %v$204
   %v$205 = getelementptr %$$Int$Int$$, ptr %v$203, i32 0, i32 1
   store i32 %v$201, ptr %v$205
   
   ret %$$Int$Int$$* %v$203
   label3:
   %v$206 = add i32 3, 0
   %v$207 = add i32 4, 0
   %v$208 = call i8* @malloc(i32 8)
   %v$209 = bitcast i8* %v$208 to %$$Int$Int$$*
   %v$210 = getelementptr %$$Int$Int$$, ptr %v$209, i32 0, i32 0
   store i32 %v$206, ptr %v$210
   %v$211 = getelementptr %$$Int$Int$$, ptr %v$209, i32 0, i32 1
   store i32 %v$207, ptr %v$211
   
   ret %$$Int$Int$$* %v$209
}
define i32 @pipeline$10(i32 %foo$bar) 
{
   %v$212 = add i32 1, 0
   %v$213 = call i8* @malloc(i32 8)
   %pipelineVar$15 = bitcast i8* %v$213 to %$$Int$Int$$*
   %v$215 = getelementptr %$$Int$Int$$, ptr %pipelineVar$15, i32 0, i32 0
   store i32 %v$212, ptr %v$215
   %v$216 = getelementptr %$$Int$Int$$, ptr %pipelineVar$15, i32 0, i32 1
   store i32 %foo$bar, ptr %v$216
   
   
   %v$217 = getelementptr %$$Int$Int$$, ptr %pipelineVar$15, i32 0, i32 1
   %v$218 = load i32, i32* %v$217
   %v$219 = add i32 1, 0
   %v$220 = add i32 %foo$bar, %v$219
   %v$221 = call i8* @malloc(i32 8)
   %pipelineVar$16 = bitcast i8* %v$221 to %$$Int$Int$$*
   %v$223 = getelementptr %$$Int$Int$$, ptr %pipelineVar$16, i32 0, i32 0
   store i32 %v$218, ptr %v$223
   %v$224 = getelementptr %$$Int$Int$$, ptr %pipelineVar$16, i32 0, i32 1
   store i32 %v$220, ptr %v$224
   
   
   %v$225 = getelementptr %$$Int$Int$$, ptr %pipelineVar$16, i32 0, i32 0
   %v$226 = load i32, i32* %v$225
   %v$227 = getelementptr %$$Int$Int$$, ptr %pipelineVar$16, i32 0, i32 1
   %v$228 = load i32, i32* %v$227
   %pipelineVar$17 = call i32 @printTuple(i32 %v$226, i32 %v$228)
   
   
   %v$230 = add i32 10, 0
   %v$231 = call i8* @malloc(i32 8)
   %pipelineVar$18 = bitcast i8* %v$231 to %$$Int$Int$$*
   %v$233 = getelementptr %$$Int$Int$$, ptr %pipelineVar$18, i32 0, i32 0
   store i32 %pipelineVar$17, ptr %v$233
   %v$234 = getelementptr %$$Int$Int$$, ptr %pipelineVar$18, i32 0, i32 1
   store i32 %v$230, ptr %v$234
   
   
   %v$235 = getelementptr %$$Int$Int$$, ptr %pipelineVar$18, i32 0, i32 0
   %v$236 = load i32, i32* %v$235
   %v$237 = getelementptr %$$Int$Int$$, ptr %pipelineVar$18, i32 0, i32 1
   %v$238 = load i32, i32* %v$237
   %pipelineVar$19 = call %$$Int$Int$$* @guard$0(i32 %v$236, i32 %v$238, i32 %foo$bar)
   
   
   %v$240 = getelementptr %$$Int$Int$$, ptr %pipelineVar$19, i32 0, i32 0
   %v$241 = load i32, i32* %v$240
   %v$242 = getelementptr %$$Int$Int$$, ptr %pipelineVar$19, i32 0, i32 1
   %v$243 = load i32, i32* %v$242
   %v$244 = call i32 @printTuple(i32 %v$241, i32 %v$243)
   
   ret i32 %v$244
}
define i32 @pipeline$11(i32 %a) 
{
   
   %v$245 = call i32 @print(i32 %a)
   
   ret i32 %v$245
}
define i32 @pipeline$12(i32 %b) 
{
   
   %v$246 = call i32 @print(i32 %b)
   
   ret i32 %v$246
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
