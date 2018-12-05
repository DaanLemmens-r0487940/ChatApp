$(function() {
    //slidedown / fade in the table of friends
    $('th').hide().slideDown();

    //fade out these elements
   /* $("#delet").click(function(){
        $(this).fadeOut(700);
    });
*/
    //button to click to add a friend
    var $addFriendButton = $('#addFriendButton');
    var $addFriendForm = $('#newFriend');

    //hide "form" and show button
    $addFriendButton.show().slideDown();
    $addFriendForm.hide();


    //when button click, hide button and show "form"
    $('#showForm').click(function(e){
        $addFriendButton.hide();
        $addFriendForm.hide().slideDown();
    });


    //after input, hide "form" and show button
    $('#addFriend').click(function(e){
        $addFriendForm.show().slideUp(function(){
            $addFriendButton.hide().slideDown();
        });
    });

    //after clicking anywhere but the input and button, hide "form" and show button
    $(document).click(function(e) {
        if (e.target.id == "showForm" || e.target.id == "friendUserId" || e.target.id == "addFriend"){
            return;
        }
        else if ($addFriendForm.is(":hidden")){
            return;
        }
        else {
            $addFriendForm.show().slideUp(function(){
                $addFriendButton.hide().slideDown();
            });
        }


    });
});
