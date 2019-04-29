$(function () {

    $(document).ready(function () {

        $("form").submit(function () {

            $.ajax({
                url: '/fibonacci',
                type: 'GET',
                data: $(this).serializeArray(),
            });
        });

    });
});