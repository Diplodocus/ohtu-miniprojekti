import miniprojekti.*;
import miniprojekti.reference.*;

description 'User can generate a BibTex file'

scenario "BibTex file is generated when at least one reference is selected", {
    given 'command generate selected', {
    }
    when 'a reference is selected', {
    }
    then 'new BibTex file is generated', {
    }
}

scenario "BibTex file is not generated when no references are selected", {
    given 'command generate selected', {
    }
    when 'no reference is selected', {
    }
    then 'new BibTex file is not generated', {
    }
}