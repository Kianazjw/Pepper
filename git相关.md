白色------正常文件的颜色 
红色------未Add的文件  
绿色------已Add，但未commit的文件  
墨蓝色----提交成功后修改过的文件  

切换为Project视图，对项目右键，Add文件。  
Commit文件可通过 项目右键--> Git --> Commit Directory...  也可点击 工具栏上的两个按钮(vcs)  
关于如何下拉代码，我们可以点击工具栏上的VCS(箭头向下)按钮，然后在在弹出框中选择 Merge 合并。

git push -f

mkdir hhh
cd hhh
git init
echo "# hhh" >> README.md
git add README.md
git commit -m "first commit"
git remote add origin https://git.coding.net/kianazjw/hhh.git
git push -u origin master