<!DOCTYPE html>
<html>
<head>
    <title>Fibonacci</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<div class="container-fluid heading">
    <h1>Ciąg Fibonacciego</h1>
</div>
<div class="container content">
    <form>
        <div class="form-group row">
            <label for="colFormLabel" class="col-sm-offset-1 col-sm-2 col-form-label">Element ciągu:</label>
            <div class="col-sm-8">
                <input type="number" min="0" class="form-control" name="result" id="colFormLabel"
                       placeholder="Element ciągu">
            </div>
            <div class="col-sm-5"></div>
            <div class="col-sm-1 count">
                <input class="btn btn-primary" type="submit" value="Oblicz">
            </div>
        </div>
    </form>
    <#if list??>
        <div>
            <p>Wynik: ${(result)! ""}</p>
        </div>
        <div>
            <p>Ciąg Fibonacciego: </p>
            <#list list>
                <#items  as Integer>
                    <ul>
                        <li>${Integer} </li>
                    </ul>
                </#items>
            </#list>
        </div>
    </#if>
</div>

<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="/js/calculate.js"></script>
</body>