var app = new Vue({
    el: '#app',
    data: {
        deptList: [],
        dept: {}
    },
    methods: {
        findAll: function () {
            axios.get('dept_list').then(
                function (response) {
                    console.log(response)
                    app.deptList = response.data;
                }
            )
        },

        findOne: function (id) {
            axios.get('dept_findOne?id=' + id).then(
                function (response) {
                    app.dept = response.data;
                }
            )
        },

        save: function () {
            if (this.dept.id == null || this.dept.id.length < 1) {
                this.add();
            } else {
                this.update();
            }
        },

        add: function () {
            $.ajax({
                type: "post",  //数据提交方式（post/get）
                url: "/dept_add",  //提交到的url
                data: {"dept.deptName": this.dept.deptName, "dept.companyName": this.dept.companyName},//提交的数据
                dataType: "json",//返回的数据类型格式
                success: function (msg) {
                    if (msg.success) {
                        app.findAll();
                    } else {
                        alert(response.data.message);
                    }
                }
            });
        },

        update: function () {
            var _this = this;
            $.ajax({
                type: "post",  //数据提交方式（post/get）
                url: "/dept_update",  //提交到的url
                data: {
                    "dept.id": this.dept.id,
                    "dept.deptName": this.dept.deptName,
                    "dept.companyName": this.dept.companyName
                },//提交的数据
                dataType: "json",//返回的数据类型格式
                success: function (msg) {
                    if (msg.success) {
                        app.findAll();
                    } else {
                        alert(response.data.message);
                    }
                }
            });

        },

        deleteOne: function (id) {
            axios.get('dept_delete?id=' + id).then(
                function (response) {
                    if (response.data.success) {
                        app.findAll();
                    } else {
                        alert(response.data.message);
                    }
                }
            )
        }


    },
    created: function () {
        //alert('加载调用');
        this.findAll();
    }
})