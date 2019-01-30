var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };
        console.log(JSON.stringify(data));
        $.ajax({
            type: 'POST',
            url: '/test',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert("error:"+error);
            console.log(error);
        });
        // dto 객체로 응답 받아야 parse error 가 안뜬다
    }

};

main.init();