layui.use('table', function() {
  var table = layui.table;

  // 已知数据渲染
  var inst = table.render({
      elem: '#employeeTab'
      ,cols: [[
        {field: 'id', title: 'ID', width: 100, sort: true}
        ,{field: 'eName', title: '员工姓名', width: 100}
        ,{field: 'eSex', title: '性别', width: 100}
        ,{field: 'eDepartment', title: '所属部门', width: 150}
        ,{field: 'eDate', title: '入职日期', width: 150}
        ,{field: 'eBirthday', title: '出生日期', width: 150}
        ,{field: 'eAssessment', title: 'HR评价', width: 570}
        ,{field: 'null', title: '员工自我评价', width: 170}
      ]]
      ,url: contextPath + 'pageEmployee'
      ,loading: true
      ,text: {none:'暂无数据', error: '系统出错,请重新加载'}
      ,even: true
      ,page: true
      ,limits: [5, 10, 15]
      ,limit: 5
    });
    //boss查看最近开除员工
    var inst = table.render({
          elem: '#deleteEmployeeTab'
          ,cols: [[
            {field: 'id', title: 'ID', width: 100, sort: true}
            ,{field: 'eName', title: '员工姓名', width: 100}
            ,{field: 'eSex', title: '性别', width: 100}
            ,{field: 'eDepartment', title: '所属部门', width: 150}
            ,{field: 'eDate', title: '入职日期', width: 150}
            ,{field: 'eBirthday', title: '出生日期', width: 150}
            ,{field: 'eAssessment', title: 'HR评价', width: 570}
          ]]
          ,url: contextPath + 'pageDeleteEmployee'
          ,loading: true
          ,text: {none:'暂无数据', error: '系统出错,请重新加载'}
          ,even: true
          ,page: true
          ,limits: [5, 10, 15]
          ,limit: 5
        });


});