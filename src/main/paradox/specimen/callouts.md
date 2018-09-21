# Callouts

Examples of the many different types of [callouts]. Additional CSS classes may
be added to make the basic `note` and `warning` callouts more specific. For
example:

```
@@@ note { .tip title="Applying an additional CSS class" }

Additional CSS classes can be applied to a callout directive by adding a dot `.`
followed by the class name inside the directive attribute section, e.g. `.tip`.

The special `.no-title` CSS class will hide the callout's title.

@@@
```

Will give

@@@ note { .tip title="Applying an additional CSS class" }

Additional CSS classes can be applied to a callout directive by adding a dot `.`
followed by the class name inside the directive attribute section, e.g. `.tip`.

The special `.no-title` CSS class will hide the callout's title.

@@@

 [callouts]: http://developer.lightbend.com/docs/paradox/current/directives/callouts.html

## Notes

@@@ note
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

@@@ note { .no-title }
With `no-title` class. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

@@@ note { title="With summary class" .summary }
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

@@@ note { title="With info or todo class" .info }
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

@@@ note { title="With tip, hint or important class" .tip }
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

@@@ note { title="With success, check or done class" .success }
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

@@@ note { title="With question, help or faq class" .question }
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

@@@ note { title="With quote or cite class" .quote }
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

## Warnings

@@@ warning
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

### Failure

@@@ warning { title="With failure, fail or missing class" .failure }
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

### Error

@@@ warning { title="With error or danger class" .error }
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@

### Bug

@@@ warning { title="With bug class" .bug }
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras arcu libero,
mollis sed massa vel, *ornare viverra ex*. Mauris a ullamcorper lacus.
@@@
